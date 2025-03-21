package com.project.Xpace.service;
import com.project.Xpace.DTO.UserDTO;
import com.project.Xpace.model.User;
import com.project.Xpace.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    public UserDTO getUserById(Long id) {
        return repo.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO(user.getId(),user.getName(),user.getEmail());
        return dto;
    }

}
