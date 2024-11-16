package com.project.Xpace.repo;

import com.project.Xpace.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppRepo extends JpaRepository<Journey,Integer> {



}
