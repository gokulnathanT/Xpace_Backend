package com.project.Xpace.service;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.DTO.UserDTO;
import com.project.Xpace.Mapper.JourneyMapper;
import com.project.Xpace.model.Journey;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.JourneyRepo;
import com.project.Xpace.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepo repo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JourneyMapper journeyMapper;

    public List<JourneyDTO> getAllJourney(){
        System.out.println("Service : Getting all journey from DB");
        List<Journey> journey=repo.findAll();
        return journey.stream().map(JourneyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public JourneyDTO getJourneyById(int id){
        Optional<Journey> journey=repo.findById(id);
        return journey.map(JourneyMapper::toDTO).orElse(null);
    }


    public List<JourneyDTO> getJourneyByUserId(int id) {
        List<Journey> journey=repo.findByCreatedBy_Id(id);
        return journey.stream().map(JourneyMapper::toDTO).collect(Collectors.toList());
    }


    public JourneyDTO createJourney(JourneyDTO journeyDTO) {
        User createdBy=userRepo.findById(journeyDTO
                        .getCreatedBy())
                        .orElseThrow(()->new RuntimeException("Created user not found"));
        User assignedIncharge = journeyDTO.getAssignedIncharge()!=null
                ?userRepo.findById(journeyDTO.getAssignedIncharge()).orElse(null):null;

        Journey journey=journeyMapper.toEntity(journeyDTO,createdBy,assignedIncharge);
        journey=repo.save(journey);

        return JourneyMapper.toDTO(journey);
    }
}