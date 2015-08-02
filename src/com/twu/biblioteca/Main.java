package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        ArrayList<Book> books = new ArrayList<>();

        Book bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true);
        books.add(bookDetails);

        Scanner in = new Scanner(System.in);
        BiblioticaApp app = new BiblioticaApp();
        Library library = new Library(books);
        View view = new View(library, in);
        Parser parser = new Parser(library, view);
        app.start(view, in, parser);
    }
}

