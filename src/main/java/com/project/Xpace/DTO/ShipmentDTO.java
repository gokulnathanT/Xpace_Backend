package com.project.Xpace.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ShipmentDTO {
    private int id;
    private int journeyId;
    private Long createdById;
    private String status;
    private LocalDateTime createdAt;

    public ShipmentDTO(int id, int journeyId, String status, Long createdById, LocalDateTime createdAt) {
        this.id = id;
        this.journeyId = journeyId;
        this.status = status;
        this.createdById = createdById;
        this.createdAt = createdAt;
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

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}


