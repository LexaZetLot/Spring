package org.example.api;

public class PaymentDTO {
    private CreditCard numberCard;
    private CurrencyType currencyType;

    public CreditCard getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(CreditCard numberCard) {
        this.numberCard = numberCard;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
