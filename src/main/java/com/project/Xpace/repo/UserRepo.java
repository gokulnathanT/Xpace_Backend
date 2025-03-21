package com.project.Xpace.repo;

import com.project.Xpace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
