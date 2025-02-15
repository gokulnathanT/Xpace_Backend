package com.project.Xpace.DTO;
import java.util.Date;
import java.util.List;
import com.project.Xpace.DTO.TouchpointDTO;
public class JourneyDTO {
    private int id;
    private Integer truck_no;
    private Integer driver_id;
    private String start;
    private String end;
    private Date s_Date;
    private Date e_Date;
    private int total_capacity;
    private int available_capacity;
    private List<TouchpointDTO> touchpoints; // Nested DTOs for touchpoints

    // Getters and Setters
}