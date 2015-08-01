package com.twu.biblioteca;

public class CheckIn implements Operations {
    private Library library;
    private View view;

    public CheckIn(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        view.printMessage("Enter the book name to return: ");
        String bookName = view.inputBook();
        if (library.returnBook(bookName)) {
            view.printMessage("Thank you for returning the book.");
        }
        else
            view.printMessage("That is not a valid book to return.");
    }
}
