package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.Objects;

import static com.twu.biblioteca.view.Messages.*;

public class ListCheckedOutItem implements Operations{
    private String option;
    private Library library;
    private View view;

    public ListCheckedOutItem(String option, Library library, View view) {
        this.option = option;
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "4")) {
            String book = library.checkedOutList();
            view.print(BOOK_HEADER);
            view.print(book);
        }
        else {
            String movie = library.checkedOutMovieList();
            view.print(MOVIE_HEADER);
            view.print(movie);
        }
    }
}
