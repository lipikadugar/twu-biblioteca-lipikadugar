package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String args[]) {
        ArrayList<String> books = new ArrayList<>(Arrays.asList("Java", "C++", "Data Structures"));
        WelcomeMessage message = new WelcomeMessage();
        message.show();
        BookList list = new BookList(books);
        View view = new View();
        view.display(list);
    }
}
