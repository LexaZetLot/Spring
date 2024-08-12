package org.example.api;

public class CurrencyType {
    private String num;
    private String nameCurrency;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }

    @Override
    public String toString() {
        return num + " " + nameCurrency;
    }
}
