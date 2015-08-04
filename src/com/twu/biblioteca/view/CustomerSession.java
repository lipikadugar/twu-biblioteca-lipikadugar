package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.Logout;
import com.twu.biblioteca.operation.Operations;

import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.ERROR_MESSAGE;
import static com.twu.biblioteca.view.Messages.MENU_FOR_USER;

public class CustomerSession implements Operations {
    private View view;
    private Library library;
    private BibliotecaApp app;
    private HashMap<String, Operations> input;
    Scanner in;

    public CustomerSession(View view, Library library, BibliotecaApp app) {

        this.view = view;
        this.library = library;
        this.app = app;
    }

    private void executeCommands(boolean execute) {
        while (execute) {
            view.print(MENU_FOR_USER);
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
        input.put("2", new CheckOut("2", library, view));
        input.put("3", new CheckIn("3", library, view));
        input.put("4", new View("4", library, in));
        input.put("5", new CheckOut("5", library, view));
        input.put("6", new CheckIn("6", library, view));
        input.put("7", new Logout(app));
        return input.get(key);
    }

    @Override
    public void execute() {
        executeCommands(true);
    }
}