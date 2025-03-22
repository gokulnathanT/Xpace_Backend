package com.project.Xpace.repo;

import com.project.Xpace.model.SpaceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceRequestRepo extends JpaRepository<SpaceRequest,Integer> {
    List<SpaceRequest> findByToJourney_Id(int journeyId);

    List<SpaceRequest> findByFromAdmin_Id(long userId);

    List<SpaceRequest> findByToAdmin_Id(long userId);
}
