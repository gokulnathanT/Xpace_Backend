package com.project.Xpace.repo;

import com.project.Xpace.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppRepo extends JpaRepository<Journey,Integer> {


//    @Query("SELECT j from journey j WHERE "+
//            "LOWER() LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
//            "LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
//            "LOWER(j.brand) LIKE LOWER(CONCAT('%', :keyword,'%')) OR "+
//            "LOWER(j.category) LIKE LOWER(CONCAT('%', :keyword,'%'))")
//    List<Journey> findAll(String );
}
