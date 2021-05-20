package com.example.myapplication;

import android.widget.EditText;

public class User {
    private String fullName,homeAddress,mobileNo,email,password;
    public User()
    {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String fullName, String homeAddress, String mobileNo, String email, String password) {
        this.fullName = fullName;
        this.homeAddress = homeAddress;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
