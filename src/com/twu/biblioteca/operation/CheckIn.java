package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class CheckIn implements Operations {
    private Library library;
    private View view;

    public CheckIn(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        view.print("Enter the book name to return: ");
        String bookName = view.inputBook();
        if (library.returnBook(bookName.toUpperCase())) {
            view.print("Thank you for returning the book.");
        } else
            view.print("That is not a valid book to return.");
    }
}
