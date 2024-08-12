package org.example.controllers;

import org.example.api.CreditCard;
import org.example.api.PaymentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {
    @RequestMapping("/payment")
    public String Payment(@ModelAttribute("paymentDTO") PaymentDTO paymentDTO){
        CreditCard creditCard = new CreditCard();
        creditCard.setFirsFourDegits(0);

        paymentDTO.setNumberCard(creditCard);
        return "payment";
    }
    @RequestMapping("/payment-result")
    public String PaymentResult(@ModelAttribute("paymentDTO") PaymentDTO paymentDTO){
        return "payment-result";
    }
}
