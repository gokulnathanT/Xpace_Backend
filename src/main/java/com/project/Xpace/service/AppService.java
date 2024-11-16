package com.project.Xpace.service;

import com.project.Xpace.model.Journey;
import com.project.Xpace.repo.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    private AppRepo repo;

    public List<Journey> getAllJourney(){
        System.out.println("service : get all journey from db");
        List<Journey> journeys=repo.findAll();
        System.out.println("data fetched : "+journeys);
        return journeys;
    }
    public Journey getTouchPointById(int id){
       return repo.findById(id).orElse(null);
    }

    public Journey getJourneyById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Journey addJourney(Journey journey) {
        return repo.save(journey);
    }

    public Journey updateJourney(int id, Journey journey) {
    return repo.save(journey);

    }

    public void deleteJourney(Journey journey1) {
        repo.delete(journey1);
    }

    public boolean updateTouchpoint(int id, int no, String touchpoint) {
        Optional<Journey> existingJourney=repo.findById(id);
        Journey journey=existingJourney.get();

        if(no==1){
            journey.setT1(touchpoint);
        }
        else if(no==2){
            journey.setT2(touchpoint);
        }
        else if(no==3){
            journey.setT3(touchpoint);
        }
        else{
            journey.setT4(touchpoint);
        }
        repo.save(journey);
        return true;

    }
    }
