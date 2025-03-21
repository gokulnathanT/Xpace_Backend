package com.project.Xpace.service;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.Mapper.JourneyMapper;
import com.project.Xpace.model.Journey;
import com.project.Xpace.repo.JourneyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepo repo;

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


}