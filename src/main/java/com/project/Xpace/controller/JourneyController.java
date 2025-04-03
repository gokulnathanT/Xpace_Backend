package com.project.Xpace.controller;

import com.project.Xpace.DTO.JourneyDTO;
import com.project.Xpace.service.JourneyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//hello
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/journeys")
public class JourneyController {

    @Autowired
    private JourneyService service;

    public JourneyController(JourneyService service){
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

    @GetMapping("/user/{id}")
    public ResponseEntity<List<JourneyDTO>> getJourneyByUserId(@PathVariable int id) {
        List<JourneyDTO> journey = service.getJourneyByUserId(id);
        return ResponseEntity.ok(journey);
    }

    @PostMapping("/create")
    public ResponseEntity<JourneyDTO> createJourney(@RequestBody JourneyDTO journeyDTO){
        try{
            JourneyDTO createdJourney =service.createJourney(journeyDTO);
            return ResponseEntity.ok(createdJourney);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(journeyDTO);
        }
    }
}