package com.project.Xpace.service;

import com.project.Xpace.DTO.SpaceRequestDTO;
import com.project.Xpace.Mapper.SpaceRequestMapper;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.SpaceRequest;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.JourneyRepo;
import com.project.Xpace.repo.SpaceRequestRepo;
import com.project.Xpace.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpaceRequestService {

    @Autowired
    private SpaceRequestRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JourneyRepo journeyRepo;

    @Autowired
    private SpaceRequestMapper spaceRequestMapper;

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

    public SpaceRequestDTO createSpaceRequest(SpaceRequestDTO spaceRequestDTO) {
        User fromAdmin =userRepo.findById(spaceRequestDTO.getFromAdminId())
                .orElseThrow(()->new RuntimeException("From Admin not found"));

        User toAdmin=userRepo.findById(spaceRequestDTO.getToAdminId())
                .orElseThrow(()->new RuntimeException("To Admin not found"));

        Journey journey=journeyRepo.findById(spaceRequestDTO.getToJourneyId())
                .orElseThrow(()->new RuntimeException("Journey not found"));

        System.out.println("Creating Space Request !");
        SpaceRequest spaceRequest= SpaceRequestMapper.toEntity(spaceRequestDTO,fromAdmin,toAdmin,journey);
        System.out.println(spaceRequest.toString());

        spaceRequest=repo.save(spaceRequest);
        return SpaceRequestMapper.toDTO(spaceRequest);
    }
}
