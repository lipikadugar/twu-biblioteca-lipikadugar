package com.twu.biblioteca.model;

import java.util.Objects;

public class User {
    private String userID;
    private String password;

    public User(String userID, String password) {

        this.userID = userID;
        this.password = password;
    }

    public boolean verify(String userID, String password) {
        return Objects.equals(userID, this.userID) && Objects.equals(password, this.password);
    }
}