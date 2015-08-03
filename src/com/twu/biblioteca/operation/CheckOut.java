package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

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
            view.print(PROMPT_BOOK_NAME);
            String bookName = view.input();
            if (library.checkout(bookName.toUpperCase())) {
                view.print(SUCCESSFUL_BOOK_CHECKOUT);
            } else
                view.print(UNSUCCESSFUL_BOOK_CHECKOUT);
        } else {
            view.print(PROMPT_MOVIE_NAME);
            String movieName = view.input();
            if (library.checkoutMovie(movieName.toUpperCase())) {
                view.print(SUCCESSFUL_MOVIE_CHECKOUT);
            } else
                view.print(UNSUCCESSFUL_MOVIE_CHECKOUT);
        }
    }
}
