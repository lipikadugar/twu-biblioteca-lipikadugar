package com.twu.biblioteca.view;

import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.operation.Parser;

import java.util.Scanner;

public class BibliotecaApp {

    private final View view;
    private final Scanner in;
    private final Parser parser;

    public BibliotecaApp(View view, Scanner in, Parser parser) {

        this.view = view;
        this.in = in;
        this.parser = parser;
    }

    public void start() {
        view.print("!!..Welcome to the Bibliotica..!!");
        while (true) {
            view.displayMenu();
            String option = in.nextLine();
            try {
                Operations operate = parser.getClassObject(option);
                operate.execute();
            } catch (NullPointerException e) {
                view.print("Select a valid option!");
            }
        }
    }
}
