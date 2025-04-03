package com.project.Xpace.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private long id;
    private String name;
    private String email;


    public UserDTO() {
    }

    public UserDTO(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Constructor




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


// Getters and Setters



}
