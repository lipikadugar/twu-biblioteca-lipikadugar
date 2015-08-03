package com.twu.biblioteca.view;

import static com.twu.biblioteca.view.Messages.*;

public class UserSession {
    private View view;

    public UserSession(View view) {

        this.view = view;
    }

    public void start() {
        view.print(MENU_FOR_USER);
    }
}
