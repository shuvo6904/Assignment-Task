package com.example.assignmentapp.model;

import java.io.Serializable;

public class LoginDataModel implements Serializable {

    private String mobile;
    private String password;

    public LoginDataModel(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
