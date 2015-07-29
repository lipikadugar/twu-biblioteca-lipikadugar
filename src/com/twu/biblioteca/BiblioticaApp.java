package com.twu.biblioteca;

import java.util.Scanner;

public class BiblioticaApp {

    public void start(View view, Library library) {
        view.welcomeMessage();
        while (true) {
            view.displayMenu();
            String name;
            Scanner in = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            int option = in.nextInt();
            switch (option) {
                case 1:
                    view.displayDetails(library);
                    break;
                case 2:
                    System.out.println("Enter the name of the book to checkout: ");
                    name = scan.nextLine();
                    System.out.println(library.checkout(name));
                    break;
                case 3:
                    System.out.println("Enter the name of the book to return: ");
                    name = scan.nextLine();
                    library.returnBook(name);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option");
            }
        }
    }
}
