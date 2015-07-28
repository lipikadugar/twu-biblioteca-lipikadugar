package com.twu.biblioteca;

import java.util.ArrayList;

public class View {
    ArrayList<String> bookList;

    public void display(BookList list) {
        bookList = (ArrayList<String>) list.getBooks();
        for (String bookName : bookList)
            System.out.println(bookName);
    }
}
