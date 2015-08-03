package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operations;

import java.util.ArrayList;
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
            System.out.println(header());
            System.out.println(library.list());
        } else {
            System.out.println(movieHeader());
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
        System.out.println("\t" + message);
    }

    public void loginScreen() {
        System.out.println("=========================================");
        System.out.println("\t\tLogin");
        System.out.println("\t1. Librarian");
        System.out.println("\t2. User");
        System.out.println("=========================================");
        System.out.println("Choose a option: ");
    }
}

