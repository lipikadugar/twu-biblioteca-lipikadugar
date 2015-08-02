package com.twu.biblioteca.model;

public class Book {
    private final String bookName;
    private final String author;
    private final int yearPublished;
    private boolean status;

    public Book(String bookName, String author, int yearPublished, boolean status) {

        this.bookName = bookName.toUpperCase();
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = status;
    }

    public boolean equals(String thatBook) {
        return bookName.equals(thatBook.toUpperCase());
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return bookName.toUpperCase();
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
