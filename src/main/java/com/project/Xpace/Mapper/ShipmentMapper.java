package com.project.Xpace.Mapper;

import com.project.Xpace.DTO.ShipmentDTO;
import com.project.Xpace.model.Shipment;

public class ShipmentMapper {
    public static ShipmentDTO toDTO(Shipment shipment){
        if(shipment==null) return null;
        return new ShipmentDTO(shipment.getId(),
                shipment.getJourneyId().getId(),
                shipment.getStatus().toString(),
                shipment.getCreatedBy().getId(),
                shipment.getCreatedAt());
    }
    public static Shipment toEntity(ShipmentDTO dto){
        if(dto==null) return null;
        Shipment shipment=new Shipment();
        shipment.setId(dto.getId());
        shipment.setStatus(Shipment.Status.valueOf(dto.getStatus()));
        shipment.setCreatedAt(dto.getCreatedAt());
        return shipment;
    }

}
