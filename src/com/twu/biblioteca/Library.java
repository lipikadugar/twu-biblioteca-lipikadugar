package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Library {
    private ArrayList<HashMap> books;

    public Library(ArrayList<HashMap> books) {
        this.books = books;
    }

    public String list() {
        String bookDetails = "";
        for (int index = 0; index < books.size(); index++) {
            HashMap book = books.get(index);
            if (book.get("availability") == "available") {
                String bookName = (String) book.get("bookName");
                String author = (String) book.get("author");
                Integer yearPublished = (Integer) book.get("yearPublished");
                bookDetails += bookName + " | " + author + " | " + yearPublished + "\n";
            }
        }
        return bookDetails;
    }

    public void checkout(String bookName) {

        for (int index = 0; index < books.size() ; index++)
        {
            HashMap book = books.get(index);
            String name = ((String) book.get("bookName")).toLowerCase();
            if (Objects.equals(name, bookName.toLowerCase()) && book.get("availability") == "available") {
                book.put("availability", "unavailable");
                System.out.println("Thank you! Enjoy the book");
                break;
            }
        }
    }
}
