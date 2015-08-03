package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

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
            view.print(PROMPT_BOOK_NAME);
            String bookName = view.input();
            if (library.returnBook(bookName.toUpperCase()))
                view.print(SUCCESSFUL_BOOK_CHECKIN);
            else
                view.print(UNSUCCESSFUL_BOOK_CHECKIN);
        } else {
            view.print(PROMPT_MOVIE_NAME);
            String movieName = view.input();
            if (library.returnMovie(movieName.toUpperCase()))
                view.print(SUCCESSFUL_MOVIE_CHECKIN);
            else
                view.print(UNSUCCESSFUL_MOVIE_CHECKIN);
        }
    }
}
