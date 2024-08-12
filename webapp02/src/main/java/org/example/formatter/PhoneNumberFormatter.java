package org.example.formatter;

import org.example.api.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneNumberFormatter implements Formatter<Phone>{
    @Override
    public Phone parse(String text, Locale locale) throws ParseException {
        Phone phone = new Phone();

        switch (text.indexOf('-')){
            case -1:
                phone.setCountryCode("7");
                phone.setUserNumber(text);
                break;
            case 0:
                phone.setCountryCode("7");
                phone.setUserNumber(text.replaceAll("-", ""));
                break;
            default:
                String[] phoneNumberArray = text.split("-");

                phone.setCountryCode(phoneNumberArray[0]);
                phone.setUserNumber(phoneNumberArray[1]);
                break;
        }
        return phone;
    }

    @Override
    public String print(Phone object, Locale locale) {
        return object.getCountryCode() + "-" + object.getUserNumber();
    }
}
