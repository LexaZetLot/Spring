package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String userName, String userEmail, String result) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Application Result");
        message.setText("Hi" + userName + "The result predicted by the LCApp is " + result);

        mailSender.send(message);
    }

    public void sendReversEmail(String userName, String userEmail, String result) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Application Result");
        message.setText("Hi" + userName);

        mailSender.send(message);
    }


    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }
}
