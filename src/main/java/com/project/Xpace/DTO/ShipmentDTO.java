package com.project.Xpace.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ShipmentDTO {
    private int id;
    private int journeyId;
    private long createdById;
    private String status;
    private int weight;
    private String pickUp;
    private String dropAt;

    public ShipmentDTO(int id, int journeyId, String status, long createdById,int weight,String pickUp,String dropAt) {
        this.id = id;
        this.journeyId = journeyId;
        this.status = status;
        this.createdById = createdById;
        this.weight=weight;
        this.pickUp=pickUp;
        this.dropAt=dropAt;
    }

    public ShipmentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(long createdById) {
        this.createdById = createdById;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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


