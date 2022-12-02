package com.example.demo.dto.request;

public class GoogleFormLogin {
    private String idToken;
    private String info;

    public GoogleFormLogin(String idToken, String info) {
        this.idToken = idToken;
        this.info = info;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
