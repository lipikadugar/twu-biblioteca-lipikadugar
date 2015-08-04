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
}