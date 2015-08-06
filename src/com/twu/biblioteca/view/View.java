package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operations;

import java.util.Objects;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.BOOK_HEADER;
import static com.twu.biblioteca.view.Messages.MOVIE_HEADER;

public class View implements Operations {

    private String option;
    private Library bookSection;
    private Library movieSection;
    private Scanner in;

    public View(String option, Library bookSection, Library movieSection, Scanner in) {
        this.option = option;
        this.bookSection = bookSection;
        this.movieSection = movieSection;
        this.in = in;
    }

    @Override
    public void execute() {
        if (Objects.equals(option, "1")) {
            print(BOOK_HEADER);
            System.out.println(bookSection.listItemDetails());
        } else {
            print(MOVIE_HEADER);
            System.out.println(movieSection.listItemDetails());
        }
    }

    public String input() {
        return in.nextLine();
    }

    public void print(String message) {
        System.out.println(message);
    }
}

