package com.project.Xpace.repo;

import com.project.Xpace.model.Journey;
import com.project.Xpace.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepo extends JpaRepository<Shipment,Integer> {
    List<Shipment> findByJourney_Id(int journeyId);
}
