package com.twu.biblioteca;

public class Book {
    private final String bookName;
    private final String author;
    private final int yearPublished;

    public Book(String bookName, String author, int yearPublished) {

        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public boolean equals(Object thatBook) {
        return bookName.equals(thatBook);
    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + yearPublished;
        return result;
    }
}
