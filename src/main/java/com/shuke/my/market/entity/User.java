package com.shuke.my.market.entity;

public class User {
    private String loginId;
    private String loginPwd;
    private String email;
    private String remMe;

    @Override
    public String toString() {
        return "User{" +
                "loginId='" + loginId + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", email='" + email + '\'' +
                ", remMe='" + remMe + '\'' +
                '}';
    }

    public void setRemMe(String remMe) {
        this.remMe = remMe;
    }

    public String getRemMe() {
        return remMe;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getEmail() {
        return email;
    }
}
