package org.example.formatter;

import org.example.api.CurrencyType;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CurrencyFormatter implements Formatter<CurrencyType> {

    @Override
    public CurrencyType parse(String text, Locale locale) throws ParseException {
        CurrencyType currencyType = new CurrencyType();
        switch (text.indexOf(' ')) {
            case -1:
                StringBuilder bufNum = new StringBuilder();
                StringBuilder bufNameCurrency = new StringBuilder();
                for(int i = 0; i < text.length(); i++) {
                    if(Character.isDigit(text.charAt(i)))
                        bufNum.append(text.charAt(i));
                    else
                        bufNameCurrency.append(text.charAt(i));
                }
                currencyType.setNum(bufNum.toString());
                currencyType.setNameCurrency(parserNameCurrency(bufNameCurrency.toString()));
                break;
            default:
                String[] parts = text.split(" ");
                currencyType.setNum(parts[0]);
                currencyType.setNameCurrency(parserNameCurrency(parts[1]));
                break;
        }

        return currencyType;
    }

    @Override
    public String print(CurrencyType object, Locale locale) {
        return object.toString();
    }

    static private String parserNameCurrency(String type){
        return switch (type) {
            case "USD" -> "$";
            case "EUR" -> "€";
            case "RUB" -> "₽";
            default -> "?????";
        };
    }
}
