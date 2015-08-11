package com.twu.biblioteca.model;

import java.util.Objects;

public class User {
    private String userID;
    private String password;
    private final String name;
    private final String email;
    private final String phone;

    public User(String userID, String password, String name, String email, String phone) {

        this.userID = userID;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean verify(String userID, String password) {
        return Objects.equals(userID, this.userID) && Objects.equals(password, this.password);
    }

    @Override
    public String toString() {
        return "UserID : " + userID +
                "\nName   : " + name +
                "\nEmail  : " + email +
                "\nPhone  : " + phone;
    }

    public String getUserId() {
        return userID;
    }

    public String details() {
        return String.format("%16s %1s \n %115s %1s \n %115s %1s\n %115s %1s\n",
                "UserID : ", userID, "Name   : ", name, "Email  : ", email, "Phone  : ", phone);
    }
}