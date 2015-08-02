package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class CheckOut implements Operations {
    private Library library;
    private View view;

    public CheckOut(String option, Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        view.print("Enter the book name to checkout: ");
        String bookName = view.inputBook();
        if (library.checkout(bookName.toUpperCase())) {
            view.print("Thank you! Enjoy the book.");
        } else
            view.print("That book is not available.");
    }
}
