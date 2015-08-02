package com.twu.biblioteca.model;

public class User {
    private final String userID;
    private final String password;

    public User(String userID, String password) {

        this.userID = userID;
        this.password = password;
    }

    public boolean verify(String userID, String password) {
        return true;
    }
}
