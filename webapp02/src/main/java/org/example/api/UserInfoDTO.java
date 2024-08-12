package org.example.api;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInfoDTO {
    @NotBlank(message = " * User Name can't be blank")
    @Size(min = 3, max = 15, message = "{userName.size}")
    private String userName;
    @NotBlank(message = " * User Name can't be blank")
    @Size(min = 3, max = 15, message = " * Your Name should have char between 3-15")
    private String crushName;
    @AssertTrue(message = "You have to agree to use our app")
    private boolean termAndConditon;
    private String result;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    @Override
    public String toString() {
        return "UserName: " + userName + ", CrushName: " + crushName;
    }

    public boolean isTermAndConditon() {
        return termAndConditon;
    }

    public void setTermAndConditon(boolean termAndConditon) {
        this.termAndConditon = termAndConditon;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
