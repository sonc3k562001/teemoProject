package com.team3.healthcare.services;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
  void sendResetPasswordMail(String to, String subject, String content);
}
