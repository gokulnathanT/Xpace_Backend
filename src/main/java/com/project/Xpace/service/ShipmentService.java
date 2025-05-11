package com.project.Xpace.service;

import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.Mapper.ShipmentMapper;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.Shipment;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.JourneyRepo;
import com.project.Xpace.repo.ShipmentRepo;
import com.project.Xpace.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShipmentMapper shipmentMapper;

    @Autowired
    private JourneyRepo journeyRepo;

    public List<ShipmentDTO> getAllShipment(int id){
        System.out.println("Service : Getting all the shipments of a journey");
        List<Shipment> shipments=repo.findByJourney_Id(id);
        return shipments.stream().map(ShipmentMapper::toDTO).collect(Collectors.toList());
    }

    public ShipmentDTO getShipmentById(int id) {
        System.out.println("Service: Getting shipment by id " + id);
        return repo.findById(id)
                .map(ShipmentMapper::toDTO)
                .orElse(new ShipmentDTO()); // Returns an empty DTO instead of exception
    }

    public ShipmentDTO createShipment(ShipmentDTO shipmentDTO) {
        User createdBy=userRepo.findById(shipmentDTO.
                getCreatedById())
                .orElseThrow(()->new RuntimeException("Created user not found"));

        Journey journey=journeyRepo.findById(shipmentDTO.getJourneyId())
                        .orElseThrow(()-> new RuntimeException("Journey not found"));
        System.out.println("Creating shipment !");

        Shipment shipment=shipmentMapper.toEntity(shipmentDTO,createdBy,journey);
        System.out.println(shipment.toString());
        shipment=repo.save(shipment);
        return ShipmentMapper.toDTO(shipment);
    }

    public ShipmentDTO setDelivered(int shipmentId) {
        Shipment shipment=repo.findById(shipmentId).orElseThrow(()->new RuntimeException("Shipment not found"));
        shipment.setStatus(Shipment.Status.DELIVERED);
        repo.save(shipment);
        return ShipmentMapper.toDTO(shipment);
    }

    public ShipmentDTO setCancelled(int shipmentId) {
        Shipment shipment=repo.findById(shipmentId).orElseThrow(()->new RuntimeException("Shipment not found"));
        shipment.setStatus(Shipment.Status.CANCELLED);
        repo.save(shipment);
        return ShipmentMapper.toDTO(shipment);
    }
}
