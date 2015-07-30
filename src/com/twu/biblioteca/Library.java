package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public String list() {
        String bookDetails = "";
        for (int index = 0; index < books.size(); index++) {
            Book book = books.get(index);
            if (book.getStatus()) {
                String bookName = book.getName();
                String author = book.getAuthor();
                Integer yearPublished = book.getYearPublished();
                bookDetails += bookName + " | " + author + " | " + yearPublished + "\n";
            }
        }
        return bookDetails;
    }

    public boolean checkout(String bookName) {
        for (int index = 0; index < books.size() ; index++)
        {
            Book book = books.get(index);
            String name = book.getName();
            if (name.equals(bookName.toUpperCase()) && (book.getStatus())) {
                book.setStatus(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        for (int index = 0; index < books.size(); index++) {
            Book book = books.get(index);
            String name = book.getName();
            if (name.equals(bookName.toUpperCase()) && !(book.getStatus())) {
                book.setStatus(true);
                return true;
            }
        }
       return false;
    }
}
