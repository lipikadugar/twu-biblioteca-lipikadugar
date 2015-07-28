package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        WelcomeMessage message = new WelcomeMessage();
        message.show();

        String[][] bookDetails = new String[][] {{"Java", "Oreilly", "1992"}, {"C++", "Kanetkar", "1998"},
                {"TDD", "Kent Beck", "2005"}};
        BookList list = new BookList(bookDetails);
        View view = new View();

        while(true) {
            System.out.println("========================================");
            System.out.println("\t\tMenu");
            System.out.println("\t1. List Books");
            System.out.println("\t2. Book Details");
            System.out.println("\t3. Quit");
            System.out.println("Choose a option: ");
            int option = in.nextInt();
            System.out.println("========================================");

            switch (option) {
                case 1: view.display(list);
                    break;
                case 2: view.displayDetails(list);
                    break;
                case 3: System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option");
            }
        }

    }
}
