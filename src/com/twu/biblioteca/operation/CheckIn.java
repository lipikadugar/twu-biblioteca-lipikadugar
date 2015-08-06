package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

public class CheckIn implements Operations {
    private final String option;
    private Library bookSection;
    private Library movieSection;
    private View view;
    private User user;

    public CheckIn(String option, Library bookSection, Library movieSection, View view, User user) {
        this.option = option;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.view = view;
        this.user = user;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "3")) {
            view.print(PROMPT_BOOK_NAME);
            String bookName = view.input();
            if (bookSection.returnItem(bookName.toUpperCase(), user))
                view.print(SUCCESSFUL_BOOK_CHECKIN);
            else
                view.print(UNSUCCESSFUL_BOOK_CHECKIN);
        } else {
            view.print(PROMPT_MOVIE_NAME);
            String movieName = view.input();
            if (movieSection.returnItem(movieName.toUpperCase(), user))
                view.print(SUCCESSFUL_MOVIE_CHECKIN);
            else
                view.print(UNSUCCESSFUL_MOVIE_CHECKIN);
        }
    }
}
