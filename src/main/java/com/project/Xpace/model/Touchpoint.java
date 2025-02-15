package com.project.Xpace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "touchpoint")
public class Touchpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "SEQUENCE")
    private int sequence; // Order of touchpoints (e.g., 1 for T1, 2 for T2)

    @ManyToOne
    @JoinColumn(name = "JOURNEY_ID", nullable = false)
    private Journey journey; // Foreign key to the Journey table

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }
}