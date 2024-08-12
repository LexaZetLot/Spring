package org.example.controllers;

import org.example.api.Info;
import org.example.api.WebsiteInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    Info severInfo;

    @RequestMapping("/test")
    public String testModelAttribute(@ModelAttribute("websiteInfoDTO") WebsiteInfoDTO websiteInfoDTO) throws IOException {
        System.out.println("@RequestMapping: inside testModelAttribute()");

        System.out.println(websiteInfoDTO.getWebsiteName());
        System.out.println(websiteInfoDTO.getWebsiteCategory());

        if(1==1){
            throw new IOException();
        }

        System.out.println("ip address of the server is" + severInfo.getServerIp());

        return "index";
    }
}
