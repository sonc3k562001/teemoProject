package com.example.project.controller;

import com.example.project.serviced.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPasswordController {
    @Autowired
    private UserPasswordService userPasswordService;

    @PostMapping("/api/forgot-password")
    public String fogotPassword(@RequestParam String email) {
        String response = userPasswordService.forgotPassword(email);

        if (!response.startsWith("duongsv89@gmail.com")) {
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }

    @PutMapping("/api/reset-passwod")
    public String resetPasswod(@RequestParam String token, @RequestParam String paswword) {
        return userPasswordService.resetPassword(token,paswword);
    }
}
