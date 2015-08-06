package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.BOOK_HEADER;
import static com.twu.biblioteca.view.Messages.MOVIE_HEADER;

public class ListCheckedOutItem implements Operations {
    private String option;
    private Library bookSection;
    private Library movieSection;
    private View view;

    public ListCheckedOutItem(String option, Library bookSection, Library movieSection, View view) {
        this.option = option;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.view = view;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "4")) {
            String book = bookSection.checkedOutItemList();
            view.print(BOOK_HEADER);
            view.print(book);
        } else {
            String movie = movieSection.checkedOutItemList();
            view.print(MOVIE_HEADER);
            view.print(movie);
        }
    }
}
