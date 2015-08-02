package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operations;

import java.util.Scanner;

public class View implements Operations {

    private Library library;
    private Scanner in;

    public View(Library library, Scanner in) {
        this.library = library;
        this.in = in;
    }

    public void displayMenu() {
        System.out.println("=========================================");
        System.out.println("\t\tMenu");
        System.out.println("\t1. List Book Details");
        System.out.println("\t2. Checkout");
        System.out.println("\t3. Return Book");
        System.out.println("\t4. List Checked Out Books");
        System.out.println("\t5. Quit");
        System.out.println("=========================================");
        System.out.println("Choose a option: ");
    }

    @Override
    public void execute() {
        System.out.println(header());
        System.out.println(library.list());
        return;
    }

    private String header() {
        String header = String.format("%-32s %-32s %-16s\n%-32s %-32s %-16s\n", "Book Name", "Author", "Year Published",
                "---------", "------", "--------------");
        return header;
    }

    public String inputBook() {
        String bookName = in.nextLine();
        return bookName;
    }

    public void print(String message) {
        System.out.println("\t" + message);
    }
}

