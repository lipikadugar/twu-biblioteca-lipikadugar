package com.twu.biblioteca.model;

public class Book implements Item {
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

    @Override
    public boolean equals(String thatBook) {
        return bookName.equals(thatBook.toUpperCase());
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String getName() {
        return bookName.toUpperCase();
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Override
    public String getDetailsAlongWithIssuedBy() {
        return String.format("%-32s %-32s %-16s %16s\n", bookName, author, yearPublished, issuedBy);
    }

    @Override
    public String getIssuedId() {
        return issuedBy;
    }

    @Override
    public String toString() {
        return String.format("%-32s %-32s %-16s\n", bookName, author, yearPublished);
    }
}
