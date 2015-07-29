package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String args[]) {
        ArrayList<HashMap> books = new ArrayList<>();

        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();
        HashMap book3 = new HashMap();
        HashMap book4 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "available");
        books.add(book2);

        book3.put("bookId", 3);
        book3.put("bookName", "The Famous Five");
        book3.put("author", "Enid Blyton");
        book3.put("yearPublished", 1993);
        book3.put("availability", "available");
        books.add(book3);

        book4.put("bookId", 4);
        book4.put("bookName", "Five Point Someone");
        book4.put("author", "Chetan Bhagat");
        book4.put("yearPublished", 2010);
        book4.put("availability", "available");
        books.add(book4);

        View view = new View();
        BiblioticaApp app = new BiblioticaApp();
        Library library = new Library(books);
        app.start(view, library);
    }
}

