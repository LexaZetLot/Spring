package org.example.controllers;

import org.example.api.EmailDTO;
import org.example.api.UserInfoDTO;
import org.example.service.LCAppEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmailController {
    @Autowired
    private LCAppEmailServiceImpl emailService;

    @RequestMapping("/sendEmail")
    public String sendEmail( Model model) {
        model.addAttribute("emailDTO", new EmailDTO());
        //model.addAttribute("userName", userName.toUpperCase());
        return "send-email-page";
    }

    @RequestMapping("/process-email")
    public String processEmail(@SessionAttribute("userInfo")UserInfoDTO userInfoDTO, @ModelAttribute("emailDTO") EmailDTO emailDTO) {

        emailService.sendEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(), userInfoDTO.getResult());
        return "process-email-page";
    }

    @RequestMapping("/review-email")
    public String reviewEmail(@SessionAttribute("userInfo")UserInfoDTO userInfoDTO, @ModelAttribute("emailDTO") EmailDTO emailDTO, Model model) {
        String review = "";
        model.addAttribute("review", review);
        emailService.sendReversEmail(userInfoDTO.getUserName(), emailDTO.getUserEmail(), userInfoDTO.getResult());
        return "review-email-page";
    }

    public LCAppEmailServiceImpl getEmailService() {
        return emailService;
    }

    public void setEmailService(LCAppEmailServiceImpl emailService) {
        this.emailService = emailService;
    }
}
