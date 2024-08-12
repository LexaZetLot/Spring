package org.example.formatter;

import org.example.api.CreditCard;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CreditCardFormatter implements Formatter<CreditCard> {
    @Override
    public CreditCard parse(String text, Locale locale) throws ParseException {
        CreditCard creditCard = new CreditCard();
        switch (count(text)){
            case -1:
                if(text.length() == 16){
                    String[] number = text.split("(?<=\\G.{" + 4 + "})");
                    creditCard = getCreditCardFromString(number);
                } else{
                    creditCard = getCreditCardFromString(0);
                }
                break;
            case 3:
                String[] number = text.split("-");
                creditCard = getCreditCardFromString(number);
                break;
            default:
                creditCard = getCreditCardFromString(0);
                break;
        }
        return creditCard;
    }

    @Override
    public String print(CreditCard object, Locale locale) {
        return object.toString();
    }

    private static int count(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++)
            if(str.charAt(i) == '-')
                count += 1;
        return count;
    }

    private static CreditCard getCreditCardFromString(String[] str){
        CreditCard creditCard = new CreditCard();
        creditCard.setFirsFourDegits(Integer.parseInt(str[0]));
        creditCard.setSecondFourDegits(Integer.parseInt(str[1]));
        creditCard.setThirdFourDegits(Integer.parseInt(str[2]));
        creditCard.setFourthFourDegits(Integer.parseInt(str[3]));
        return creditCard;
    }
    private static CreditCard getCreditCardFromString(int num){
        CreditCard creditCard = new CreditCard();
        creditCard.setFirsFourDegits(num);
        creditCard.setSecondFourDegits(num);
        creditCard.setThirdFourDegits(num);
        creditCard.setFourthFourDegits(num);
        return creditCard;
    }
}
