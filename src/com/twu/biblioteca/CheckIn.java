package com.twu.biblioteca;

public class CheckIn implements Operations {
    private final Library library;
    private final View view;

    public CheckIn(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        View.printMessage("Enter the book name to return: ");
        String bookName = view.inputBook();
        if (library.checkout(bookName)) {
            System.out.println("Thank you! Enjoy the book.");
        }
        else
            System.out.println("That is not a valid book to return.");
    }
}
