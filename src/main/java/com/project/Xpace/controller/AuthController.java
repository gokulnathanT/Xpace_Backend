package com.project.Xpace.controller;

import com.project.Xpace.JWT.JWTUtil;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserRepo userrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody User user){
        if(userrepo.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email already exists");
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return ResponseEntity.ok(userrepo.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword())
        );
        System.out.println("Logged In");
        String token= jwtUtil.generateToken(authRequest.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @Getter @Setter
    public static class AuthRequest{
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    @Getter
    public static class AuthResponse{
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }


}
