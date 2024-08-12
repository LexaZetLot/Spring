package org.example.controllers;

import jakarta.validation.Valid;
import org.example.api.UserInfoDTO;
import org.example.service.LCAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("userInfoDTO")
public class WebAppController {
    @Autowired
    private LCAppService lcAppService;


    @RequestMapping("/")
    public String showHome(Model model){
        model.addAttribute("userInfoDTO", new UserInfoDTO());
        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO, BindingResult bindingResult){
        model.addAttribute("userInfoDTO", userInfoDTO);
        model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfoDTO", bindingResult);

        if(bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for(ObjectError error : errors){
                System.out.println(error.getDefaultMessage());
            }
            return "home-page";
        }

        userInfoDTO.setResult(lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName()));

        return "result-page";
    }
}
