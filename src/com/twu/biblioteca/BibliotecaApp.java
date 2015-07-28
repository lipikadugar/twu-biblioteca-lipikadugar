package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[][] bookDetails = new String[][] {{"Java", "Oreilly", "1992"}, {"C++", "Kanetkar", "1998"},
                {"TDD", "Kent Beck", "2005"}, {"Vinci code", "Dan Brown", "1982"}};
        BookList list = new BookList(bookDetails);
        View view = new View();
        WelcomeMessage message = new WelcomeMessage();
        message.show(list, view, in);
    }
}

