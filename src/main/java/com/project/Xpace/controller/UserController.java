package com.project.Xpace.controller;


import com.project.Xpace.DTO.UserDTO;
import com.project.Xpace.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/users")
public class UserController {

    @Autowired
    public UserService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user=service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/profile")
    public String getProfile(){
        return "Welcome to your profile ! This is a protected endpoint.";
    }

}
