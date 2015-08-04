package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.*;

import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.*;

public class BibliotecaApp {
    private View view;
    private Library library;
    private UserAuthentication librarian;
    private UserAuthentication customer;
    private HashMap<String, Operations> input;
    private Scanner in;

    public BibliotecaApp(View view, Scanner in, Library library, UserAuthentication librarian, UserAuthentication customer) {

        this.view = view;
        this.in = in;
        this.library = library;
        this.librarian = librarian;
        this.customer = customer;
    }

    public void start(boolean executeMenu) {
        view.print(WELCOME_MESSAGE);
        executeCommands(executeMenu);
    }

    private void executeCommands(boolean execute) {
        while (execute) {
            view.print(LOGIN_MENU);
            String option = view.input();
            try {
                Operations operate = getClassObject(option);
                operate.execute();
            } catch (NullPointerException e) {
                view.print(ERROR_MESSAGE);
            }
        }
    }

    public Operations getClassObject(String key) {
        input = new HashMap<>();
        input.put("1", new View("1", library, in));
        input.put("2", new View("2", library, in));
        input.put("3", new PromptUser("3", view, librarian, library, this));
        input.put("4", new PromptUser("4", view, customer, library, this));
        input.put("5", new QuitApp());
        return input.get(key);
    }
}
