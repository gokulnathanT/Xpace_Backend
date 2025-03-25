package com.project.Xpace.repo;

import com.project.Xpace.model.Journey;
import com.project.Xpace.model.SpaceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JourneyRepo extends JpaRepository<Journey,Integer> {
    List<Journey> findByCreatedBy_Id(long createdById);


}
