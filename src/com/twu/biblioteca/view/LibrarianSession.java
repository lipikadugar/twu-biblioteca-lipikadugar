package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.*;

import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.ERROR_MESSAGE;
import static com.twu.biblioteca.view.Messages.MENU_FOR_LIBRARIAN;

public class LibrarianSession implements Operations {
    private View view;
    private Library library;
    private HashMap<String, Operations> input;
    Scanner in;

    public LibrarianSession(View view, Library library) {

        this.view = view;
        this.library = library;
    }

    public void start(boolean executeMenu) {
        view.print(MENU_FOR_LIBRARIAN);
        executeCommands(executeMenu);
    }

    private void executeCommands(boolean execute) {
        while (execute) {
            String option = view.input();
            try {
                Operations operate = getClassObject(option);
                operate.execute();
            } catch (NullPointerException e) {
                view.print(ERROR_MESSAGE);
            }
            start(execute);
        }
    }

    public Operations getClassObject(String key) {
        input = new HashMap<>();
        input.put("1", new View("1", library, in));
        input.put("2", new CheckOut("2", library, view));
        input.put("3", new CheckIn("3", library, view));
        input.put("4", new ListCheckedOutItem("4", library, view));
        input.put("5", new View("5", library, in));
        input.put("6", new CheckOut("6", library, view));
        input.put("7", new ListCheckedOutItem("7", library, view));
        input.put("8", new CheckIn("8", library, view));
        input.put("9", new Logout(new BibliotecaApp(view, in, library)));
        return input.get(key);
    }

    @Override
    public void execute() {
        start(true);
    }
}
