package com.example.demo.dto.response;

import com.example.demo.model.Role;

import java.util.List;

public class JwtResponseGoogle {
    private String token;
    private String type = "Bearer";
    private String name;
    private String avatar;


    public JwtResponseGoogle() {
    }

    public JwtResponseGoogle(String token, String name, String avatar) {
        this.token = token;
        this.name = name;
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
