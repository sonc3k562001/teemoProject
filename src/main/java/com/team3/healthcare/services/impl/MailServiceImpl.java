package com.team3.healthcare.services.impl;

import com.team3.healthcare.services.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

  private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

  @Value("${spring.mail.username}")
  private String from;
  
  @Autowired
  private JavaMailSender mailSender;
  
  @Override
  public void sendResetPasswordMail(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);
    message.setFrom(from);
    try {
      mailSender.send(message);
    } catch (Exception e) {
      logger.error("Cannot send email: {}", e);
    }

  }
  
}
