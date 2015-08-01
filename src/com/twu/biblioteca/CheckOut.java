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
        view.printMessage("Enter the book name to checkout: ");
        String bookName = view.inputBook();
        if (library.checkout(bookName)) {
            System.out.println("Thank you! Enjoy the book.");
        }
        else
            System.out.println("That book is not available.");
    }
}
