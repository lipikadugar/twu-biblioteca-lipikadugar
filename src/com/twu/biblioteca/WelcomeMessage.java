package com.twu.biblioteca;

import java.util.Scanner;

public class WelcomeMessage {
    public void show(BookList list, View view, Scanner in) {
        this.show();
        int option;
        while (true) {
            System.out.println("=========================================");
            System.out.println("\t\tMenu");
            System.out.println("\t1. List Books");
            System.out.println("\t2. Book Details");
            System.out.println("\t3. Quit");
            System.out.println("Choose a option: ");
            option = in.nextInt();
            System.out.println("=========================================");

            switch (option) {
                case 1:
                    view.display(list);
                    break;
                case 2:
                    view.displayDetails(list);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }

    public void show() {
        System.out.print("\t!!..Welcome to the Bibliotica..!!\n");
    }
}
