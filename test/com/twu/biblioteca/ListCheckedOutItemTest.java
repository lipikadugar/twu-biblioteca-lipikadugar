package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ListCheckedOutItemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Item> books;
    ArrayList<Item> movies;
    Book bookDetails;
    Movie movieDetails;
    Library bookSection;
    Library movieSection;
    Scanner in;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, false, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, false, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true, "");
        books.add(bookDetails);
        bookSection = new Library(books);

        movies = new ArrayList<>();
        movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, false, "Nancy");
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, false, "Yasmin");
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true, "");
        movies.add(movieDetails);
        movieSection = new Library(movies);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldListCheckedOutBookList() {
        Library library = new Library(books, movies);
        View view = new View("4", library, movieSection, in);
        ListCheckedOutItem item = new ListCheckedOutItem("7", library, movieSection, view);

        item.execute();

        assertEquals("Movie Name                       Director                         Release Year     Rating                  Issued By\n" +
                "----------                       --------                         ------------     -------                 ---------\n" +
                "\n" +
                "CHAK DE INDIA                    Shimit Amin                      2007             8                           Nancy\n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9                          Yasmin\n" +
                "\n", outContent.toString());
    }
}
