package com.project.Xpace.controller;

import com.project.Xpace.model.Journey;
import com.project.Xpace.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
   @Autowired
   private AppService service;

    @GetMapping("/Journey")
    public ResponseEntity<List<Journey>> getAllJourney(){
        System.out.println("fetching all journey ");
        List<Journey> journeys=service.getAllJourney();
        System.out.println("journey retrieved: "+journeys);
        return new ResponseEntity<>(journeys, HttpStatus.OK);
    }
    @GetMapping("/Journey/{id}")
    public ResponseEntity<Journey> getJourney(@PathVariable int id){
        Journey journey=service.getJourneyById(id);
        if(journey!=null){
            return new ResponseEntity<>(journey,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/Journey",consumes="application/json")
    public ResponseEntity<?> addJourney(@RequestBody Journey journey){
        try{
            System.out.println(journey.toString());
            Journey journey1=service.addJourney(journey);
            return new ResponseEntity<>(journey1,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/Journey/{id}")
    public ResponseEntity<String> updateJourney(@PathVariable int id,@RequestBody Journey journey) throws IOException {

        Journey journey1=null;
        journey1=service.updateJourney(id,journey);
        if(journey1!=null){
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
    }


}
