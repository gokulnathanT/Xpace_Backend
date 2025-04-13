package com.project.Xpace.DTO;

import com.project.Xpace.model.SpaceRequest.Status;
import java.time.LocalDateTime;

public class SpaceRequestDTO {
    private int id;
    private long fromAdminId;
    private long toAdminId;
    private int toJourneyId;
    private int requestedCapacity;
    private LocalDateTime createdAt;
    private Status status;
    private String pickUp;
    private String dropAt;

    // Constructors
    public SpaceRequestDTO() {}

    public SpaceRequestDTO(int id, long fromAdminId, long toAdminId, int toJourneyId, int requestedCapacity,LocalDateTime createdAt, Status status,String pickUp,String dropAt) {
        this.id = id;
        this.fromAdminId = fromAdminId;
        this.toAdminId = toAdminId;
        this.toJourneyId = toJourneyId;
        this.requestedCapacity = requestedCapacity;
        this.createdAt=createdAt;
        this.status = status;
        this.pickUp=pickUp;
        this.dropAt=dropAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFromAdminId() {
        return fromAdminId;
    }

    public void setFromAdminId(long fromAdminId) {
        this.fromAdminId = fromAdminId;
    }

    public long getToAdminId() {
        return toAdminId;
    }

    public void setToAdminId(long toAdminId) {
        this.toAdminId = toAdminId;
    }

    public int getToJourneyId() {
        return toJourneyId;
    }

    public void setToJourneyId(int toJourneyId) {
        this.toJourneyId = toJourneyId;
    }

    public int getRequestedCapacity() {
        return requestedCapacity;
    }

    public void setRequestedCapacity(int requestedCapacity) {
        this.requestedCapacity = requestedCapacity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDropAt() {
        return dropAt;
    }

    public void setDropAt(String dropAt) {
        this.dropAt = dropAt;
    }
}
