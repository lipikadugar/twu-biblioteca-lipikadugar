package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operations;

import java.util.Objects;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.BOOK_HEADER;
import static com.twu.biblioteca.view.Messages.MOVIE_HEADER;

public class View implements Operations {

    private String option;
    private Library library;
    private Scanner in;

    public View(String option, Library library, Scanner in) {
        this.option = option;
        this.library = library;
        this.in = in;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "1")) {
            print(BOOK_HEADER);
            System.out.println(library.list());
        } else {
            print(MOVIE_HEADER);
            System.out.println(library.listMovies());
        }
    }

    public String input() {
        return in.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }
}

