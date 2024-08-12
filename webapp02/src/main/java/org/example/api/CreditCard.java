package org.example.api;

public class CreditCard {
    private Integer firsFourDegits;
    private Integer secondFourDegits;
    private Integer thirdFourDegits;
    private Integer fourthFourDegits;

    public Integer getFirsFourDegits() {
        return firsFourDegits;
    }

    public void setFirsFourDegits(Integer firsFourDegits) {
        this.firsFourDegits = firsFourDegits;
    }

    public Integer getSecondFourDegits() {
        return secondFourDegits;
    }

    public void setSecondFourDegits(Integer secondFourDegits) {
        this.secondFourDegits = secondFourDegits;
    }

    public Integer getThirdFourDegits() {
        return thirdFourDegits;
    }

    public void setThirdFourDegits(Integer thirdFourDegits) {
        this.thirdFourDegits = thirdFourDegits;
    }

    public Integer getFourthFourDegits() {
        return fourthFourDegits;
    }

    public void setFourthFourDegits(Integer fourthFourDegits) {
        this.fourthFourDegits = fourthFourDegits;
    }

    @Override
    public String toString() {
        if(firsFourDegits == 0)
            return "XXXX-XXXX-XXXX-XXXX";
        else
            return firsFourDegits + "-" + secondFourDegits + "-" +
                   thirdFourDegits + "-" + fourthFourDegits;
    }
}
