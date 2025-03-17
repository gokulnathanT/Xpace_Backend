package com.project.Xpace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shipments")
public class Shipment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "journey_id",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name="fk_journey_id"))
    private Journey journey;

    @ManyToOne
    @JoinColumn(name = "created_by",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name="fk_created_by"))
    private User createdBy;

    public enum Status{
        IN_TRANSIT,DELIVERED,CANCELLED
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Shipment.Status status= Status.IN_TRANSIT;

    @Column(name = "created_at",updatable=false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Journey getJourneyId() {
        return journey;
    }

    public void setJourneyId(Journey journeyId) {
        this.journey = journeyId;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
