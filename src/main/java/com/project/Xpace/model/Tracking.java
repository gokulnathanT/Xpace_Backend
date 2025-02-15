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
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "JOURNEY_ID", nullable = false)
    private Journey journey; // Foreign key to the Journey table

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }
}