package org.example.controllers;

import org.example.api.WebsiteInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice(assignableTypes = TestController.class)
@SessionAttributes("websiteInfoDTO")
public class MyWebsiteController {
    @ModelAttribute
    public WebsiteInfoDTO getwebsiteInfoDTO(){
        System.out.println("***************************");
        WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
        websiteInfoDTO.setWebsiteName("websiteName");
        websiteInfoDTO.setWebsiteCategory("Education");
        System.out.println("***************************");
        return websiteInfoDTO;
    }

    @ModelAttribute("headerModel")
    public String websiteHeader(){
        System.out.println("inside model attribute method: websiteHeader()");
        return "Selenium Express";
    }

    @RequestMapping("/showInfo")
    public String showWebsiteInfo(@ModelAttribute("websiteInfoDTO")WebsiteInfoDTO websiteInfoDTO) {
        System.out.println("@RequestMapping: inside showWebsiteInfo()");

        websiteInfoDTO.setWebsiteName("SiteName.com");
        websiteInfoDTO.setWebsiteCategory("Education");

        System.out.println(websiteInfoDTO.getWebsiteName());
        System.out.println(websiteInfoDTO.getWebsiteCategory());

        return "index";
    }

    @RequestMapping("/showCompanyInfo")
    public String showCompanyInfo(@ModelAttribute("websiteInfoDTO")WebsiteInfoDTO websiteInfoDTO) {
        System.out.println("@RequestMapping: inside showCompanyInfo()");

        System.out.println(websiteInfoDTO.getWebsiteName());
        System.out.println(websiteInfoDTO.getWebsiteCategory());

        return "index";
    }

    @RequestMapping("/header")
    public String getHeader(@ModelAttribute("headerModel")String header) {
        System.out.println("@RequestMapping: inside showCompanyInfo()");

        System.out.println(header);

        return "index";
    }

}
