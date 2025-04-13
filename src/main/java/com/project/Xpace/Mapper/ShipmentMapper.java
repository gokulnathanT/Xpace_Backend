package com.project.Xpace.Mapper;

import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.Shipment;
import com.project.Xpace.model.User;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {
    public static ShipmentDTO toDTO(Shipment shipment){
        if(shipment==null) return null;
        return new ShipmentDTO(shipment.getId(),
                shipment.getJourneyId().getId(),
                shipment.getStatus().toString(),
                shipment.getCreatedBy().getId(),
                shipment.getWeight(),
                shipment.getPickUp(),
                shipment.getDropAt());
    }
    public Shipment toEntity(ShipmentDTO dto, User createdBy,Journey journey){
        if(dto==null) return null;
        Shipment shipment=new Shipment();
        shipment.setId(dto.getId());
        shipment.setStatus(Shipment.Status.valueOf(dto.getStatus()));
        shipment.setCreatedBy(createdBy);
        shipment.setJourneyId(journey);
        shipment.setWeight(dto.getWeight());
        shipment.setPickUp(dto.getPickUp());
        shipment.setDropAt(dto.getDropAt());
        return shipment;
    }

}
