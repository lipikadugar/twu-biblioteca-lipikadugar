package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;

import static com.twu.biblioteca.view.Messages.*;

public class PromptUser implements Operations {
    private final View view;
    private final UserAuthentication user;
    private final Library library;

    public PromptUser(View view, UserAuthentication librarian, Library library) {
        this.view = view;
        this.user = librarian;
        this.library = library;
    }

    @Override
    public void execute() {
        view.print(USER_ID);
        String userID = view.input();
        view.print(PASSWORD);
        String password = view.input();
        if (user.authenticate(userID, password)) {
            new LibrarianSession(view, library).execute();
        }
        else
            view.print(INVALID_USER);
    }
}
