package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

public class CheckOut implements Operations {
    private String option;
    private Library library;
    private View view;

    public CheckOut(String option, Library library, View view) {
        this.option = option;
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "2")) {
            view.print("Enter the book name to checkout: ");
            String bookName = view.inputBook();
            if (library.checkout(bookName.toUpperCase())) {
                view.print("Thank you! Enjoy the book.");
            } else
                view.print("That book is not available.");
        } else {
            view.print("Enter the movie name to checkout: ");
            String movieName = view.inputBook();
            if (library.checkoutMovie(movieName.toUpperCase())) {
                view.print("Thank you! Enjoy the movie.");
            } else
                view.print("That movie is not available.");
        }
    }
}
