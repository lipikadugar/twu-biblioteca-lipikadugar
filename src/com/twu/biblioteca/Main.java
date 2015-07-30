package com.twu.biblioteca;

import java.util.ArrayList;

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

        View view = new View();
        BiblioticaApp app = new BiblioticaApp();
        Library library = new Library(books);
        app.start(view, library);
    }
}

