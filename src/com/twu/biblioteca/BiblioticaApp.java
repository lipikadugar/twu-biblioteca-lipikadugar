package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BiblioticaApp {

    public void start(ArrayList<HashMap> list, View view, Scanner in) {
        view.welcomeMessage();
        while (true) {
            view.displayMenu();
            int option = in.nextInt();
            switch (option) {
                case 1:
                    view.displayDetails(list);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }
}
