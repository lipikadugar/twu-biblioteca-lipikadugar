package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.operation.PromptUser;
import com.twu.biblioteca.operation.QuitApp;

import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.ERROR_MESSAGE;

public class Dispatcher implements IView {

    private final View view;
    private final Library bookSection;
    private final Library movieSection;
    private final UserAuthentication librarian;
    private final UserAuthentication customer;
    private Scanner in;
    private HashMap<String, Operations> input;

    public Dispatcher(View view, Scanner in, Library bookSection, Library movieSection, UserAuthentication librarian, UserAuthentication customer) {

        this.view = view;
        this.in = in;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.librarian = librarian;
        this.customer = customer;
    }

    public Operations getClassObject(String key) {
        input = new HashMap<>();
        input.put("1", new View("1", bookSection, movieSection, in));
        input.put("2", new View("2", bookSection, movieSection, in));
        input.put("3", new PromptUser("3", view, librarian, bookSection, movieSection));
        input.put("4", new PromptUser("4", view, customer, bookSection, movieSection));
        input.put("5", new QuitApp());
        return input.get(key);
    }

    @Override
    public IView execute() {
        String option = view.input();
        try {
            Operations operate = getClassObject(option);
            operate.execute();
        } catch (NullPointerException e) {
            view.print(ERROR_MESSAGE);
        }
        return this;
    }
}
