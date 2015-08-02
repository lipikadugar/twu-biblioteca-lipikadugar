package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

public class CheckIn implements Operations {
    private final String option;
    private Library library;
    private View view;

    public CheckIn(String option, Library library, View view) {
        this.option = option;
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "3")) {
            view.print("Enter the book name to return: ");
            String bookName = view.input();
            if (library.returnBook(bookName.toUpperCase()))
                view.print("Thank you for returning the book.");
            else
                view.print("That is not a valid book to return.");
        } else {
            view.print("Enter the movie name to return: ");
            String movieName = view.input();
            if (library.returnMovie(movieName.toUpperCase()))
                view.print("Thank you for returning the movie.");
        }
    }
}
