package com.project.Xpace.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="journey")
public class Journey {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int id;
        @Column(nullable = false)
        private String truck_no;
        @Column(nullable = false)
        private int driverId;
        @Column(nullable = false)
        private String startLocation;
        @Column(nullable = false)
        private String endLocation;
        @Column(nullable = false)
        private LocalDate startDate;
        @Column(nullable = false)
        private LocalDate endDate;
        @Column(nullable = false)
        private int totalCapacity;
        @Column(nullable = false)
        private int availableCapacity;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Journey.Status status =Status.SCHEDULED;

        public enum Status {
            SCHEDULED,
            IN_PROGRESS,
            COMPLETED,
            CANCELLED
        }



        @ManyToOne
        @JoinColumn(name = "assigned_incharge",referencedColumnName = "id",foreignKey = @ForeignKey(name="fk_assigned_incharge"))
        private User assignedIncharge;

        @ManyToOne
        @JoinColumn(name = "created_by",referencedColumnName = "id",nullable = false, foreignKey = @ForeignKey(name="fk_created_by"))
        private User createdBy;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTruck_no() {
            return truck_no;
        }

        public void setTruck_no(String truck_no) {
            this.truck_no = truck_no;
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

        public int getTotalCapacity() {
            return totalCapacity;
        }

        public void setTotalCapacity(int totalCapacity) {
            this.totalCapacity = totalCapacity;
        }

        public int getAvailableCapacity() {
            return availableCapacity;
        }

        public void setAvailableCapacity(int availableCapacity) {
            this.availableCapacity = availableCapacity;
        }

        public User getAssignedIncharge() {
            return assignedIncharge;
        }

        public void setAssignedIncharge(User assignedIncharge) {
            this.assignedIncharge = assignedIncharge;
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
}
