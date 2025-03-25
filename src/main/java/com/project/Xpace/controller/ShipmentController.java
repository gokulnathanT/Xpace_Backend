package com.project.Xpace.controller;


import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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



}
