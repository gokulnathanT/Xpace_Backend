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
        PENDING,APPROVERD,REJECTED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private  Status status=Status.PENDING;
}
