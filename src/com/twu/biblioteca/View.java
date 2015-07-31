package com.twu.biblioteca;

public class View implements Operations {

    private Library library;

    public View(Library library) {
        this.library = library;
    }

    public void welcomeMessage() {
        System.out.print("\t!!..Welcome to the Bibliotica..!!\n");
    }

    public void displayMenu() {
        System.out.println("=========================================");
        System.out.println("\t\tMenu");
        System.out.println("\t1. List Book Details");
        System.out.println("\t2. Checkout");
        System.out.println("\t3. Return Book");
        System.out.println("\t4. Quit");
        System.out.println("=========================================");
        System.out.println("Choose a option: ");
    }

    @Override
    public void execute() {
        System.out.println(library.list());
        return;
    }
}

