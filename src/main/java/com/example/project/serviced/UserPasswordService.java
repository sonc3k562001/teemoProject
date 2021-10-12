package com.example.project.serviced;

import com.example.project.model.UserPassword;
import com.example.project.repository.UserPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserPasswordService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private UserPasswordRepository userPasswordRepository;

    public String forgotPassword(String email) {
        Optional<UserPassword> userPasswordOptional = Optional.ofNullable(userPasswordRepository.findByEmail(email));
        if (!userPasswordOptional.isPresent()) {
            return "Invalid email";
        }

        UserPassword userPassword = userPasswordOptional.get();
        userPassword.setToken(gennerateToken());
        userPassword.setTokenCreationDate(LocalDateTime.now());
        userPassword = userPasswordRepository.save(userPassword);

        return userPassword.getToken();
    }

    public String resetPassword(String token, String password) {
        Optional<UserPassword> userPasswordOptional = Optional.ofNullable(userPasswordRepository.findByToken(token));

        if (!userPasswordOptional.isPresent()) {
            return "Invalid token.";
        }
        LocalDateTime tokenCreationDate = userPasswordOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired";
        }

        UserPassword userPassword = userPasswordOptional.get();
        userPassword.setPassword(password);
        userPassword.setToken(null);
        userPassword.setTokenCreationDate(null);

        userPasswordRepository.save(userPassword);

        return "your passwod succesfully update";
    }

    private String gennerateToken() {

        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

    private boolean isTokenExpired(final LocalDateTime tokencreationDate) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokencreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
