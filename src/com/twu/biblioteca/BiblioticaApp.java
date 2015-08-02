package com.twu.biblioteca;

import java.util.Scanner;

public class BiblioticaApp {

    public void start(View view, Scanner in, Parser parse) {
        view.printMessage("!!..Welcome to the Bibliotica..!!");
        while (true) {
            view.displayMenu();
            String option = in.nextLine();
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
