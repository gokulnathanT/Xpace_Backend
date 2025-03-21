package com.project.Xpace.service;

import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.Mapper.ShipmentMapper;
import com.project.Xpace.model.Shipment;
import com.project.Xpace.repo.ShipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepo repo;

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

}
