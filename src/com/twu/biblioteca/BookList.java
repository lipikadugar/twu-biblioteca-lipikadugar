package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    ArrayList<String> bookList;

    public BookList(String book) {

        bookList = new ArrayList<>();
        bookList.add(book);
    }

    public List<String> showBooks() {
        return bookList;
    }
}
