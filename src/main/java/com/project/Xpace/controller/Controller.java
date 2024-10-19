package com.project.Xpace.controller;

import com.project.Xpace.model.Journey;
import com.project.Xpace.repo.AppRepo;
import com.project.Xpace.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private AppService service;

    @Autowired
    private AppRepo repo;

    @GetMapping("/Journey")
    public ResponseEntity<List<Journey>> getAllJourney() {
        System.out.println("fetching all journey ");
        List<Journey> journeys = service.getAllJourney();
        System.out.println("journey retrieved: " + journeys);
        return new ResponseEntity<>(journeys, HttpStatus.OK);
    }

    @GetMapping("/Journey/{id}")
    public ResponseEntity<Journey> getJourney(@PathVariable int id) {
        Journey journey = service.getJourneyById(id);
        if (journey != null) {
            return new ResponseEntity<>(journey, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/Journey", consumes = "application/json")
    public ResponseEntity<?> addJourney(@RequestBody Journey journey) {
        try {
            System.out.println(journey.toString());
            Journey journey1 = service.addJourney(journey);
            return new ResponseEntity<>(journey1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/Journey/{id}")
    public ResponseEntity<String> updateJourney(@PathVariable int id, @RequestBody Journey journey) throws IOException {

//        Journey journey1=null;
//        journey1=service.updateJourney(id,journey);
//        if(journey1!=null){
//            return new ResponseEntity<>("Updated",HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
//        }

        Optional<Journey> existingJourney = repo.findById(id);
        if (existingJourney.isPresent()) {
            Journey JourneyUpdate = existingJourney.get();
            JourneyUpdate.setTruck_no(journey.getTruck_no());
            JourneyUpdate.setDriver_id(journey.getDriver_id());
            JourneyUpdate.setStart(journey.getStart());
            JourneyUpdate.setEnd(journey.getEnd());
            JourneyUpdate.setT1(journey.getT1());
            JourneyUpdate.setT2(journey.getT2());
            JourneyUpdate.setT3(journey.getT3());
            JourneyUpdate.setT4(journey.getT4());
            JourneyUpdate.setS_Date(journey.getS_Date());
            JourneyUpdate.setE_Date(journey.getE_Date());
            JourneyUpdate.setTotal_capacity(journey.getTotal_capacity());
            JourneyUpdate.setAvailable_capacity(journey.getAvailable_capacity());

            repo.save(JourneyUpdate);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Journey not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/Journey/tp/{id}")
    public ResponseEntity<List<String>> getTouchPointById(@PathVariable int id) throws IOException {
        Journey  journey1 = service.getTouchPointById(id);
        if(journey1!=null){
            List<String> TouchPoints=new ArrayList<>();
            TouchPoints.add(journey1.getT1());
            TouchPoints.add(journey1.getT2());
            TouchPoints.add(journey1.getT3());
            TouchPoints.add(journey1.getT4());
            return new ResponseEntity<>(TouchPoints, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


