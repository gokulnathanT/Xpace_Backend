package com.project.Xpace.Mapper;

import com.project.Xpace.DTO.SpaceRequestDTO;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.User;
import com.project.Xpace.model.SpaceRequest;
import org.springframework.stereotype.Component;

@Component
public class SpaceRequestMapper {
    public static SpaceRequestDTO toDTO(SpaceRequest request){
        if(request==null) return null;
        return new SpaceRequestDTO(request.getId(),
                request.getFromAdmin().getId(),
                request.getToAdmin().getId(),
                request.getToJourney().getId(),
                request.getRequestedCapacity(),
                request.getCreatedAt(),
                request.getStatus(),
                request.getPickUp(),
                request.getDropAt());
    }

    public static SpaceRequest toEntity(SpaceRequestDTO dto, User fromAdmin, User toAdmin, Journey toJourney){
        if(dto==null)return null;
        return new SpaceRequest(dto.getId(),
                fromAdmin,
                toAdmin,
                toJourney,
                dto.getRequestedCapacity(),
                dto.getStatus(),
                dto.getPickUp(),
                dto.getDropAt()
                );
    }


}
