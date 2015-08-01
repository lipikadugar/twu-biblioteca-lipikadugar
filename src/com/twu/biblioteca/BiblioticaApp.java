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
            switch (option) {
                case "1":
                    Operations operate = parse.getClassObject(option);
                    operate.execute();
                    break;
                case "2":
                    operate = parse.getClassObject(option);
                    operate.execute();
                    break;
                case "3":
                    operate = parse.getClassObject(option);
                    operate.execute();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }
}
