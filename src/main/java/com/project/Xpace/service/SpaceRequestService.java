package com.project.Xpace.service;

import com.project.Xpace.DTO.SpaceRequestDTO;
import com.project.Xpace.Mapper.SpaceRequestMapper;
import com.project.Xpace.model.SpaceRequest;
import com.project.Xpace.repo.SpaceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpaceRequestService {

    @Autowired
    private SpaceRequestRepo repo;

    public List<SpaceRequestDTO> getAllSpaceRequestByJourneyId(int id){
        System.out.println("Service : Getting all the space request for a journey");
        List<SpaceRequest> spaceRequests=repo.findByToJourney_Id(id);
        return spaceRequests.stream().map(SpaceRequestMapper::toDTO).collect(Collectors.toList());
    }
    public List<SpaceRequestDTO> getAllSpaceRequestByToAdminId(int id){
        System.out.println("Service : Getting all the space request to admin for a journey ");
        List<SpaceRequest> spaceRequests=repo.findByToAdmin_Id(id);
        return spaceRequests.stream().map(SpaceRequestMapper::toDTO).collect(Collectors.toList());
    }
    public List<SpaceRequestDTO> getAllSpaceRequestByFromAdminId(int id){
        System.out.println("Service : Getting all the space request from admin for a journey");
        List<SpaceRequest> spaceRequests=repo.findByFromAdmin_Id(id);
        return spaceRequests.stream().map(SpaceRequestMapper::toDTO).collect(Collectors.toList());
    }
}
