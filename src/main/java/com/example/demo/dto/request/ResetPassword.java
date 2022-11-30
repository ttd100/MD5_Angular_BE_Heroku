package com.example.demo.dto.request;
public class ResetPassword {
    public String newpassword;
    public String token;

    public ResetPassword(String newpassword, String token) {
        this.newpassword = newpassword;
        this.token = token;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
