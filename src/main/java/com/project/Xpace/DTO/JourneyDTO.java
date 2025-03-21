package com.project.Xpace.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@NoArgsConstructor
public class JourneyDTO {
    private int id;
    private String truckNo;
    private int driverId;
    private String startLocation;
    private String endLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalCapacity;
    private int availableCapacity;

    private UserDTO assignedIncharge;  // Nested DTO for assigned incharge
    private UserDTO createdBy;  // Nested DTO for created by

    public JourneyDTO(int id, String truckNo, int driverId, String startLocation, String endLocation, LocalDate startDate, LocalDate endDate, int totalCapacity, int availableCapacity, UserDTO assignedIncharge, UserDTO createdBy) {
        this.id = id;
        this.truckNo = truckNo;
        this.driverId = driverId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCapacity = totalCapacity;
        this.availableCapacity = availableCapacity;
        this.assignedIncharge = assignedIncharge;
        this.createdBy = createdBy;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public UserDTO getAssignedIncharge() {
        return assignedIncharge;
    }

    public void setAssignedIncharge(UserDTO assignedIncharge) {
        this.assignedIncharge = assignedIncharge;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }
}
