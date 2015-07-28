package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String args[]) {
        WelcomeMessage message = new WelcomeMessage();
        message.show();

        String[][] bookDetails = new String[][] {{"Java", "Oreilly", "1992"}, {"C++", "Kanetkar", "1998"},
                {"TDD", "Kent Beck", "2005"}};
        BookList list = new BookList(bookDetails);
        View view = new View();

        System.out.println("\n==List of Books==");
        view.display(list);
        System.out.println("\n==Details of Books==");
        view.displayDetails(list);
    }
}
