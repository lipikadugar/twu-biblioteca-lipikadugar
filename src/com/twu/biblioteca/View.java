package com.twu.biblioteca;

public class View {

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

    public String displayDetails(Library book) {
        String books = book.list();
        System.out.println(books);
        return books;
    }
}

