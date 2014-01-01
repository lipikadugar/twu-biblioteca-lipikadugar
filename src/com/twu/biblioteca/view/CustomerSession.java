package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.ERROR_MESSAGE;
import static com.twu.biblioteca.view.Messages.MENU_FOR_USER;

public class CustomerSession implements Session {
    private View view;
    private Library bookSection;
    private Library movieSection;
    private User user;
    private HashMap<String, Operations> input;
    Scanner in;

    public CustomerSession(View view, Library bookSection, Library movieSection, User user) {

        this.view = view;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.user = user;
    }

    public Operations getClassObject(String key) {
        input = new HashMap<>();
        input.put("1", new View("1", bookSection, movieSection, in));
        input.put("2", new CheckOut("2", bookSection, movieSection, view, user));
        input.put("3", new CheckIn("3", bookSection, bookSection, view, user));
        input.put("4", new View("4", bookSection, movieSection, in));
        input.put("5", new CheckOut("5", bookSection, movieSection, view, user));
        input.put("6", new CheckIn("6", bookSection, bookSection, view, user));
        input.put("7", new UserInformation(user, view));
        return input.get(key);
    }

    @Override
    public void executeCommands(boolean execute) {
        while (execute) {
            view.print(MENU_FOR_USER);
            String option = view.input();
            try {
                Operations operate = getClassObject(option);
                if (Objects.equals(option, "8"))
                    execute = false;
                else
                    operate.execute();
            } catch (NullPointerException e) {
                view.print(ERROR_MESSAGE);
            }
        }
    }
}
