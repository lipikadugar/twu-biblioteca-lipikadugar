package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<HashMap> books;

    public Library(ArrayList<HashMap> books) {
        this.books = books;
    }

    public String list() {
        String name = (String) books.get(0).get("bookName");
        for (int index = 1; index < books.size() ; index++)
        {
            HashMap book = books.get(index);
            book.get("bookName");
            name += " | " + book.get("bookName");
        }
        return name;
    }

    public boolean checkout(String bookName) {
        for (int index = 0; index < books.size() ; index++)
        {

            HashMap book = books.get(index);
            if (book.get("bookName") == bookName) {
                book.remove("bookName");
                System.out.println("Successful Checkout");
                return true;
            }
        }
        return false;
    }
}
