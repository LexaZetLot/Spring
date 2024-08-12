package org.example.controllers;

import jakarta.validation.Valid;
import org.example.api.CommunicationDTO;
import org.example.api.Phone;
import org.example.api.UserRegistrationDTO;
import org.example.propertyeditor.NamePropertyEditor;
import org.example.validator.EmailValidator;
import org.example.validator.UserNameValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String showRegisterPage(@ModelAttribute("registrationDTO") UserRegistrationDTO registrationDTO) {
        registrationDTO.setName("Name");
        registrationDTO.setUserName("User Name");

        Phone phone = new Phone();
        phone.setCountryCode("21");
        phone.setUserNumber("123456789");

        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setPhone(phone);
        registrationDTO.setCommunicationDTO(communicationDTO);

        return "register";
    }
    @RequestMapping("/registeration-sucess")
    public String showRegistrationSuccessPage(@Valid @ModelAttribute("registrationDTO") UserRegistrationDTO registrationDTO, BindingResult bindingResult) {
        System.out.println(bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors)
                System.out.println(error);
            return "register";
        }
        return "registration-success";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //binder.setDisallowedFields("name");

        System.out.println("initBinder");

        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, "name", trimmerEditor);

        NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
        binder.registerCustomEditor(String.class, "name", namePropertyEditor);

        binder.addValidators(new UserNameValidator());
        binder.addValidators(new EmailValidator());
    }
}