package com.project.Xpace.Mapper;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.DTO.UserDTO;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JourneyMapper {

    @Autowired
    private UserRepo userRepo;

    public static JourneyDTO toDTO(Journey journey) {
        if (journey == null) return null;

        JourneyDTO dto=new JourneyDTO();
        dto.setId(journey.getId());
        dto.setTruckNo(journey.getTruck_no());
        dto.setDriverId(journey.getDriverId());
        dto.setStartLocation(journey.getStartLocation());
        dto.setEndLocation(journey.getEndLocation());
        dto.setStartDate(journey.getStartDate());
        dto.setEndDate(journey.getEndDate());
        dto.setStatus(journey.getStatus().toString());
        dto.setTotalCapacity(journey.getTotalCapacity());
        dto.setAvailableCapacity(journey.getAvailableCapacity());


        dto.setCreatedBy(journey.getCreatedBy()!=null?journey.getCreatedBy().getId():null);
        dto.setAssignedIncharge(journey.getAssignedIncharge()!=null?journey.getAssignedIncharge().getId():null);


        return dto;
    }

    public Journey toEntity(JourneyDTO dto,User createdBy,User assignedIncharge) {
       if(dto==null){
           return null;
       }

       Journey journey=new Journey();
       journey.setTruck_no(dto.getTruckNo());
       journey.setDriverId(dto.getDriverId());
       journey.setStartLocation(dto.getStartLocation());
       journey.setEndLocation(dto.getEndLocation());
       journey.setStartDate(dto.getStartDate());
       journey.setEndDate(dto.getEndDate());
       journey.setTotalCapacity(dto.getTotalCapacity());
       journey.setAvailableCapacity(dto.getAvailableCapacity());
       journey.setStatus(Journey.Status.valueOf(dto.getStatus()));
       journey.setCreatedBy(createdBy);
       journey.setAssignedIncharge(assignedIncharge);

       return journey;
    }
}
