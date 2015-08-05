package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

public class CheckOut implements Operations {
    private String option;
    private Library library;
    private View view;
    private User user;

    public CheckOut(String option, Library library, View view, User user) {
        this.option = option;
        this.library = library;
        this.view = view;
        this.user = user;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "2")) {
            view.print(PROMPT_BOOK_NAME);
            String bookName = view.input();
            if (library.checkout(bookName.toUpperCase(), user)) {
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
