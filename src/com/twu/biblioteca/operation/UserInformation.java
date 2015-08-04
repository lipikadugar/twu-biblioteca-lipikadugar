package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.View;

public class UserInformation implements Operations {
    private User user;
    private View view;

    public UserInformation(User user, View view) {
        this.user = user;
        this.view = view;
    }

    @Override
    public void execute() {
        view.print(user.toString());
    }
}
