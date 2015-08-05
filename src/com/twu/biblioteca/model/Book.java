package com.twu.biblioteca.model;

public class Book {
    private String bookName;
    private String issuedBy;
    private String author;
    private int yearPublished;
    private boolean status;

    public Book(String bookName, String author, int yearPublished, boolean status, String issuedBy) {
        this.issuedBy = issuedBy;
        this.bookName = bookName.toUpperCase();
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = status;
    }

    public boolean equals(String thatBook) {
        return bookName.equals(thatBook.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("%-32s %-32s %-16s\n", bookName, author, yearPublished);
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return bookName.toUpperCase();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getBookDetailsAlongWithIssuedBy() {
        return String.format("%-32s %-32s %-16s %16s\n", bookName, author, yearPublished, issuedBy);
    }

    public String getIssuedId() {
        return issuedBy;
    }
}
