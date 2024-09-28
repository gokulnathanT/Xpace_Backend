package com.project.Xpace.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="journey")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="TRUCK_NO")
    private Integer truck_no;
    @Column(name="DRIVER_ID")
    private int Driver_id;
    @Column(name="START")
    private String start;
    @Column(name="`END`")
    private String end;
    @Column(name="T1")
    private String T1;
    @Column(name="T2")
    private String T2;
    @Column(name="T3")
    private String T3;
    @Column(name="T4")
    private String T4;
    @Column(name="S_Date")
    private LocalDate S_Date;
    @Column(name="E_Date")
    private LocalDate E_Date;
    @Column(name="Total_capacity")
    private int Total_capacity;
    @Column(name="available_capacity")
    private int available_capacity;

}
