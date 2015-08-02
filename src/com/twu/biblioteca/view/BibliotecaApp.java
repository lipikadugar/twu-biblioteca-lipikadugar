package com.twu.biblioteca.view;

import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.operation.Parser;
import com.twu.biblioteca.view.View;

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
        view.printMessage("!!..Welcome to the Bibliotica..!!");
        while (true) {
            view.displayMenu();
            String option = in.nextLine();
            try {
                Operations operate = parser.getClassObject(option);
                operate.execute();
            }
            catch (NullPointerException e)
            {
                view.printMessage("Select a valid option!");
            }
        }
    }
}
