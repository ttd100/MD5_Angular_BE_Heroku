package com.example.demo.dto.request;

public class SendEmail {
    private String sendEmail;
    private String info;

    public SendEmail(String sendEmail, String info) {
        this.sendEmail = sendEmail;
        this.info = info;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
