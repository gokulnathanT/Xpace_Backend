package com.project.Xpace.controller;


import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.model.Journey;
import com.project.Xpace.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;


    @GetMapping("/{journeyId}")
    public List<ShipmentDTO> getAllShipments(@PathVariable int journeyId){
        System.out.println("Controller : Fetching shipments for journey ID "+journeyId);
        return shipmentService.getAllShipment(journeyId);
    }

    @GetMapping("/{journeyId}/shipment/{shipmentId}")
    public ShipmentDTO getShipmentById(@PathVariable int shipmentId){
        System.out.println("Fetching the shipment data for particular journey ");
        return shipmentService.getShipmentById(shipmentId);
    }

    @PostMapping("/create")
    public ResponseEntity<ShipmentDTO> createShipment(@RequestBody ShipmentDTO shipmentDTO){
        System.out.println(shipmentDTO.toString());
        try{
            ShipmentDTO createdShipment=shipmentService.createShipment(shipmentDTO);

            return ResponseEntity.ok(createdShipment);
        }
        catch (RuntimeException e){
            System.out.println(shipmentDTO.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(shipmentDTO);
        }
    }

    @PutMapping("/updateDelivered/{shipmentId}")
    public ResponseEntity<?> setDelivered(@PathVariable int shipmentId){
        try{
            ShipmentDTO deliveredShipment=shipmentService.setDelivered(shipmentId);
            return ResponseEntity.ok(deliveredShipment);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(shipmentId);
        }
    }

    @PutMapping("/updateCancel/{shipmentId}")
    public ResponseEntity<?> setCancelled(@PathVariable int shipmentId){
        try{
            ShipmentDTO cancelledShipment=shipmentService.setCancelled(shipmentId);
            return ResponseEntity.ok(cancelledShipment);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(shipmentId);
        }
    }
}
