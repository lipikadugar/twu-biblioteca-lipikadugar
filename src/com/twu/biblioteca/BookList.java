package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    ArrayList<String> bookList;

    public BookList(ArrayList<String> book) {

        bookList = new ArrayList<>();
        bookList.addAll(book);
    }

    public List<String> getBooks() {
        return bookList;
    }
}
