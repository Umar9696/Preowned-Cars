package com.preowned.service;

import com.preowned.model.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInquiryEmail(String toEmail, Inquiry inquiry) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("New Inquiry from " + inquiry.getName());
        message.setText("Name: " + inquiry.getName() + "\n"
                + "Email: " + inquiry.getEmail() + "\n"
                + "Phone: " + inquiry.getPhone() + "\n"
                + "Message: " + inquiry.getMessage());

        mailSender.send(message);
    }
}
