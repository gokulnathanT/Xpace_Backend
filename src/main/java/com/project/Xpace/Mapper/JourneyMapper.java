package com.project.Xpace.Mapper;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.DTO.UserDTO;
import com.project.Xpace.model.Journey;

public class JourneyMapper {
    public static JourneyDTO toDTO(Journey journey){
        if(journey==null) return null;
        return new JourneyDTO(
                journey.getId(),
                journey.getTruck_no(),
                journey.getDriverId(),
                journey.getStartLocation(),
                journey.getEndLocation(),
                journey.getStartDate(),
                journey.getEndDate(),
                journey.getTotalCapacity(),
                journey.getAvailableCapacity(),
                journey.getAssignedIncharge() != null
                        ? new UserDTO(
                        journey.getAssignedIncharge().getId(),
                        journey.getAssignedIncharge().getName(),
                        journey.getAssignedIncharge().getEmail()
                )
                        : null,
                new UserDTO(
                        journey.getCreatedBy().getId(),
                        journey.getCreatedBy().getName(),
                        journey.getCreatedBy().getEmail()
                )
        );


    }
    public static Journey toEntity(JourneyDTO dto) {
        if (dto == null) return null;

        Journey journey = new Journey();
        journey.setId(dto.getId());
        journey.setTruck_no(dto.getTruckNo());
        journey.setDriverId(dto.getDriverId());
        journey.setStartLocation(dto.getStartLocation());
        journey.setEndLocation(dto.getEndLocation());
        journey.setStartDate(dto.getStartDate());
        journey.setEndDate(dto.getEndDate());
        journey.setTotalCapacity(dto.getTotalCapacity());
        journey.setAvailableCapacity(dto.getAvailableCapacity());
        return journey;
    }


}
