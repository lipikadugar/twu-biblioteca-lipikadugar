package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    ArrayList<String> bookList;
    ArrayList<String [][]> bookDetails;

    public BookList(ArrayList<String> book) {

        bookList = new ArrayList<>();
        bookList.addAll(book);
    }

    public BookList(String[][] bookDetails) {
        this.bookDetails = new ArrayList<>();
        this.bookDetails.add(bookDetails);
    }

    public List<String> getBooks() {
        return bookList;
    }

    public List<String[][]> getDetails() {
        return bookDetails;
    }
}
