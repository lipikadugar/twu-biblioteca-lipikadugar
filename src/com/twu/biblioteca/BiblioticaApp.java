package com.twu.biblioteca;

import java.util.Scanner;

public class BiblioticaApp {

    public void start(View view, Library library) {
        view.welcomeMessage();
        while (true) {
            view.displayMenu();
            Scanner in = new Scanner(System.in);
            String option = in.nextLine();
            Parser parse = new Parser(library, view);
            try {
                Operations operate = parse.getClassObject(option);
                operate.execute();
            }
            catch (NullPointerException e)
            {
                InvalidOption invalid = new InvalidOption(view);
                invalid.execute();
            }
        }
    }
}
