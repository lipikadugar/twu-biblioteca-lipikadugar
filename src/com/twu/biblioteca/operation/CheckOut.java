package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

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
        if (library.checkout(bookName.toUpperCase())) {
            view.printMessage("Thank you! Enjoy the book.");
        }
        else
            view.printMessage("That book is not available.");
    }
}
