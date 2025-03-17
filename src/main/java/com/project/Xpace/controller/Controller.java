package com.project.Xpace.controller;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.model.Journey;
import com.project.Xpace.repo.AppRepo;
import com.project.Xpace.service.AppService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
//hello
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/journeys")
public class Controller {

    @Autowired
    private AppService service;

    public Controller(AppService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<JourneyDTO>> getAllJourney(){
        List<JourneyDTO> journeys=service.getAllJourney();
        return ResponseEntity.ok(journeys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourneyDTO> getJourneyById(@PathVariable int id){
        JourneyDTO journey=service.getJourneyById(id);
        return ResponseEntity.ok(journey);
    }


}