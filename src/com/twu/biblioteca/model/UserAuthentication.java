package com.twu.biblioteca.model;

import java.util.ArrayList;

public class UserAuthentication {
    private ArrayList<User> users;

    public UserAuthentication(ArrayList<User> users) {
        this.users = users;
    }

    public boolean authenticate(User newUser) {
        for (User user : users) {
            if (user.verify(newUser.getUserID(), newUser.getPassword()))
                return true;
        }
        return false;
    }
}
