package org.example.service;

import org.example.api.EmailDTO;

public interface LCAppEmailService {
    void sendEmail(String userName, String userEmail, String result);
}