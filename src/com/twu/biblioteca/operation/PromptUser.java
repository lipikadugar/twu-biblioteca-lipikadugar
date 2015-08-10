package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.Initiator.BibliotecaApp;
import com.twu.biblioteca.view.CustomerSession;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

public class PromptUser implements Operations {
    private String choice;
    private View view;
    private UserAuthentication newUser;
    private Library bookSection;
    private Library movieSection;
    private BibliotecaApp app;

    public PromptUser(String choice, View view, UserAuthentication user, Library bookSection, Library movieSection) {
        this.choice = choice;
        this.view = view;
        this.newUser = user;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
    }

    @Override
    public void execute() {
        view.print(USER_ID);
        String userID = view.input();
        view.print(PASSWORD);
        String password = view.input();
        User user = newUser.authenticate(userID, password);
        if (user == null)
            view.print(INVALID_USER);
        else {
            Session session = buildSession(user);
            session.executeCommands(true);
        }
    }

    private Session buildSession(User user) {
        if (Objects.equals(choice, "3"))
            return new LibrarianSession(view, bookSection, movieSection, user);
        else
            return new CustomerSession(view, bookSection, movieSection, user);
    }
}
