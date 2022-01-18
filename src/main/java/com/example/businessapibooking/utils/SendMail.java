package com.example.businessapibooking.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SendMail {
    @Autowired
    JavaMailSender mailSender;

    public void sendMailSender(String toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ducdvph12299@fpt.edu.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Send Email...");
    }
}
