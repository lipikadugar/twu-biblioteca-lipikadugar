package com.twu.biblioteca;

public class CheckOut implements Operations {
    private Library library;
    private View view;

    public CheckOut(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        String bookName = view.inputBook();
        if (library.checkout(bookName)) {
            System.out.println("Thank you for returning the book.");
        }
        else
            System.out.println("That book is not available.");
    }
}
