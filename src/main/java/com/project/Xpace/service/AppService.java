package com.project.Xpace.service;

import com.project.Xpace.model.Journey;
import com.project.Xpace.repo.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Journey getJourneyById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Journey addJourney(Journey journey) {
        return repo.save(journey);
    }

    public Journey updateJourney(int id, Journey journey) {
    return repo.save(journey);

    }
}
