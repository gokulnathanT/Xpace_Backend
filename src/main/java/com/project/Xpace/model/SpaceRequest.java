package com.project.Xpace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name="space_requests")
public class SpaceRequest {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "from_admin",referencedColumnName = "id",nullable = false,foreignKey =@ForeignKey(name="fk_from_admin"))
    private User fromAdmin;

    @ManyToOne
    @JoinColumn(name = "to_admin",referencedColumnName = "id",nullable = false,foreignKey =@ForeignKey(name="fk_to_admin"))
    private User toAdmin;

    @ManyToOne
    @JoinColumn(name = "to_journey_id",referencedColumnName = "id",nullable = false,foreignKey =@ForeignKey(name="fk_to_journey_id"))
    private Journey toJourney;

    @Column(nullable = false)
    private int requestedCapacity;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable=false)
    private LocalDateTime createdAt=LocalDateTime.now();

    public enum Status{
        PENDING,APPROVED,REJECTED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Status status=Status.PENDING;

    @Column(nullable = false)
    private String pickUp;

    @Column(nullable = false)
    private String dropAt;

    public SpaceRequest(int id, User fromAdmin, User toAdmin, Journey toJourney, int requestedCapacity, Status status ,String pickUp,String dropAt ) {
        this.id = id;
        this.fromAdmin = fromAdmin;
        this.toAdmin = toAdmin;
        this.toJourney = toJourney;
        this.requestedCapacity = requestedCapacity;
        this.createdAt=LocalDateTime.now();
        this.status = status;
        this.pickUp=pickUp;
        this.dropAt=dropAt;
    }

    public SpaceRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFromAdmin() {
        return fromAdmin;
    }

    public void setFromAdmin(User fromAdmin) {
        this.fromAdmin = fromAdmin;
    }

    public User getToAdmin() {
        return toAdmin;
    }

    public void setToAdmin(User toAdmin) {
        this.toAdmin = toAdmin;
    }

    public Journey getToJourney() {
        return toJourney;
    }

    public void setToJourney(Journey toJourney) {
        this.toJourney = toJourney;
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
