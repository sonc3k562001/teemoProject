package com.example.project.repository;

import com.example.project.model.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPasswordRepository extends JpaRepository<UserPassword, Long> {

    UserPassword findByEmail(String email);

    UserPassword findByToken(String token);
}
