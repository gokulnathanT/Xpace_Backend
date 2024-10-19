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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTruck_no() {
        return truck_no;
    }

    public void setTruck_no(Integer truck_no) {
        this.truck_no = truck_no;
    }

    public int getDriver_id() {
        return Driver_id;
    }

    public void setDriver_id(int driver_id) {
        Driver_id = driver_id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getT1() {
        return T1;
    }

    public void setT1(String t1) {
        T1 = t1;
    }

    public String getT2() {
        return T2;
    }

    public void setT2(String t2) {
        T2 = t2;
    }

    public String getT3() {
        return T3;
    }

    public void setT3(String t3) {
        T3 = t3;
    }

    public String getT4() {
        return T4;
    }

    public void setT4(String t4) {
        T4 = t4;
    }

    public LocalDate getS_Date() {
        return S_Date;
    }

    public void setS_Date(LocalDate s_Date) {
        S_Date = s_Date;
    }

    public LocalDate getE_Date() {
        return E_Date;
    }

    public void setE_Date(LocalDate e_Date) {
        E_Date = e_Date;
    }

    public int getTotal_capacity() {
        return Total_capacity;
    }

    public void setTotal_capacity(int total_capacity) {
        Total_capacity = total_capacity;
    }

    public int getAvailable_capacity() {
        return available_capacity;
    }

    public void setAvailable_capacity(int available_capacity) {
        this.available_capacity = available_capacity;
    }
}
