package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.operation.PromptUser;
import com.twu.biblioteca.operation.QuitApp;

import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.ERROR_MESSAGE;

public class BibliotecaApp {
    private View view;
    private Library bookSection;
    private Library movieSection;
    private UserAuthentication librarian;
    private UserAuthentication customer;
    private WelcomeView welcome;
    private HashMap<String, Operations> input;
    private Scanner in;

    public BibliotecaApp(View view, Scanner in, Library bookSection, Library movieSection, UserAuthentication librarian, UserAuthentication customer, WelcomeView welcome) {

        this.view = view;
        this.in = in;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.librarian = librarian;
        this.customer = customer;
        this.welcome = welcome;
    }

    public void start(boolean executeMenu) {
        while (executeMenu) {
            welcome.execute();
            performOperation();
        }
    }

    public void performOperation() {
        String option = view.input();
        try {
            Operations operate = getClassObject(option);
            operate.execute();
        } catch (NullPointerException e) {
            view.print(ERROR_MESSAGE);
        }
    }

    public Operations getClassObject(String key) {
        input = new HashMap<>();
        input.put("1", new View("1", bookSection, movieSection, in));
        input.put("2", new View("2", bookSection, movieSection, in));
        input.put("3", new PromptUser("3", view, librarian, bookSection, movieSection, this));
        input.put("4", new PromptUser("4", view, customer, bookSection, movieSection, this));
        input.put("5", new QuitApp());
        return input.get(key);
    }
}
