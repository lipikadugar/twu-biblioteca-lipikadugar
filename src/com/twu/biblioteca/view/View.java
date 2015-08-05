package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operations;

import java.util.Objects;
import java.util.Scanner;

import static com.twu.biblioteca.view.Messages.*;

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
        if(Objects.equals(option, "1")) {
            print(BOOK_HEADER);
            System.out.println(library.list());
        } else {
            print(MOVIE_HEADER);
            System.out.println(library.listMovies());
        }
        return;
    }

    private String movieHeader() {
        String header = String.format("%-32s %-32s %-16s %-16s\n%-32s %-32s %-16s %-16s\n", "Movie Name", "Director", "Release Year", "Rating",
                "----------", "--------", "------------", "-------");
        return header;
    }

    private String header() {
        String header = String.format("%-32s %-32s %-16s\n%-32s %-32s %-16s\n", "Book Name", "Author", "Year Published",
                "---------", "------", "--------------");
        return header;
    }

    public String input() {
        String name = in.nextLine();
        return name;
    }

    public void print(String message) {
        System.out.println(message);
    }
}

