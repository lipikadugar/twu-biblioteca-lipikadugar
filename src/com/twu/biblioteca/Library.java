package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public String list() {
        String bookDetails = String.format("%-32s %-32s %-16s\n\n", "Book Name", "Author", "Year Published");
        for (Book book : books) {
            if (book.getStatus()) {
                String bookName = book.getName();
                String author = book.getAuthor();
                Integer yearPublished = book.getYearPublished();
                bookDetails += String.format("%-32s %-32s %-16s\n", bookName, author, yearPublished);
            }
        }
        return bookDetails;
    }

    public boolean checkout(String bookName) {
        for (Book book : books) {
            String name = book.getName();
            if (name.equals(bookName.toUpperCase()) && (book.getStatus())) {
                book.setStatus(false);
                return true;
            }
        }
        return false;
    }

    public String returnBook(String bookName) {
        for (Book book : books) {
            String name = book.getName();
            if (name.equals(bookName.toUpperCase()) && !(book.getStatus())) {
                book.setStatus(true);
                return "Thank you for returning the book.";
            }
        }
       return "That is not a valid book to return.";
    }
}
