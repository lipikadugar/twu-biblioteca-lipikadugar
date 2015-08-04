package com.twu.biblioteca.model;

import java.util.ArrayList;

public class UserAuthentication {
    private ArrayList<User> users;

    public UserAuthentication(ArrayList<User> users) {
        this.users = users;
    }

    public boolean authenticate(String userID, String password) {
        for (User user : users) {
            if (user.verify(userID, password))
                return true;
        }
        return false;
    }
}
