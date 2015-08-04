package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.CustomerSession;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

public class PromptUser implements Operations {
    private String choice;
    private final View view;
    private final UserAuthentication user;
    private final Library library;
    private BibliotecaApp app;

    public PromptUser(String choice, View view, UserAuthentication user, Library library, BibliotecaApp bibliotecaApp) {
        this.choice = choice;
        this.view = view;
        this.user = user;
        this.library = library;
        this.app = bibliotecaApp;
    }

    @Override
    public void execute() {
        view.print(USER_ID);
        String userID = view.input();
        view.print(PASSWORD);
        String password = view.input();
        if (user.authenticate(userID, password)) {
            if (Objects.equals(choice, "3"))
                new LibrarianSession(view, library, app).execute();
            else
                new CustomerSession(view, library, app).execute();
        }
        else
            view.print(INVALID_USER);
    }
}
