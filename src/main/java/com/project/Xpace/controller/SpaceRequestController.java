package com.project.Xpace.controller;

import com.project.Xpace.DTO.SpaceRequestDTO;
import com.project.Xpace.model.SpaceRequest;
import com.project.Xpace.service.SpaceRequestService;
import jakarta.websocket.server.PathParam;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/spacerequests")
public class SpaceRequestController {


    @Autowired
    private SpaceRequestService request;

    @GetMapping("journey/{journeyId}")
    public List<SpaceRequestDTO> getAllSpaceRequestsByJourneyId(@PathVariable int journeyId){
        System.out.println("Controller : Fetching space requests for journey ID");
        return request.getAllSpaceRequestByJourneyId(journeyId);
    }

    @GetMapping("toAdmin/{userId}")
    public List<SpaceRequestDTO> getAllSpaceRequestsToAdminByUserId(@PathVariable int userId){
        System.out.println("Controller : Fetching space requests for admin ID (Sent)");
        return request.getAllSpaceRequestByToAdminId(userId);
    }

    @GetMapping("fromAdmin/{userId}")
    public List<SpaceRequestDTO> getAllSpaceRequestsFromAdminByUserId(@PathVariable int userId){
        System.out.println("Controller : Fetching space requests for admin ID (Received)");
        return request.getAllSpaceRequestByFromAdminId(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<SpaceRequestDTO> createSpaceRequest(@RequestBody SpaceRequestDTO spaceRequestDTO){
        try{
            SpaceRequestDTO createdSpaceRequest=request.createSpaceRequest(spaceRequestDTO);
            return ResponseEntity.ok(createdSpaceRequest);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(spaceRequestDTO);
        }
    }

    @PutMapping("/update/{spaceRequestId}")
    public ResponseEntity<?>SpaceRequest(@PathVariable int spaceRequestId){
        try{
            SpaceRequestDTO updatedSpaceRequest=request.updateSpaceRequest(spaceRequestId);
            return ResponseEntity.ok(updatedSpaceRequest);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(spaceRequestId);
        }
    }

    @PutMapping("/updateAccept/{spaceRequestId}")
    public ResponseEntity<?> SpaceRequestAccepted(@PathVariable int spaceRequestId){
        try{
            SpaceRequestDTO acceptedSpaceRequest=request.acceptSpaceRequest(spaceRequestId);
            return ResponseEntity.ok(acceptedSpaceRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(spaceRequestId);
        }
    }

    @DeleteMapping("/deleteSpaceRequest/{spaceRequestId}")
    public ResponseEntity<?> deleteSpaceRequest(@PathVariable int spaceRequestId){
        try{
            SpaceRequestDTO deletedSpaceRequest=request.deleteSpaceRequest(spaceRequestId);
            return ResponseEntity.ok(deletedSpaceRequest);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(spaceRequestId);
        }
    }

}
