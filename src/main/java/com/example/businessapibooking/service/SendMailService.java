package com.example.businessapibooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("duongduc1308@gmail.com");
        message.setTo(toEmail);
        message.setText("ok đã đặt lịch thành công");
        message.setSubject("Email Thông Báo Lịch Khám Tại Booking EYE");

        mailSender.send(message);
        System.out.println("Mail Send...");
    }
}
