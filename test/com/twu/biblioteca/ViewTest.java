package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static com.twu.biblioteca.view.Messages.*;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Book> books;
    ArrayList<Movie> movies;
    Book bookDetails;
    Library library;
    Scanner in;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true, "");
        books.add(bookDetails);

        movies = new ArrayList<>();
        Movie movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true);
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true);
        movies.add(movieDetails);

        library = new Library(books, movies);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        View view = new View("1", library, in);

        view.print(WELCOME_MESSAGE);

        assertEquals("\t!!..Welcome to the Bibliotica..!!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayDetailsOfAllTheBook() {
        Library library = new Library(books, movies);
        View view = new View("1", library, in);

        view.execute();

        assertEquals("Book Name                        Author                           Year Published  \n" +
                "---------                        ------                           --------------  \n\n" +
                "JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n\n", outContent.toString());
    }

    @Test
    public void shouldDisplayDetailsOfAllTheMovies() {
        Library library = new Library(books, movies);
        View view = new View("5", library, in);

        view.execute();

        assertEquals("Movie Name                       Director                         Release Year     Rating          \n" +
                "----------                       --------                         ------------     -------         \n\n" +
                "MEN IN BLACK                     Barry Sonnenfeld                 1997             7               \n" +
                "CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9               \n" +
                "BHAAG MILKHA BHAAG               Rakesh omprakash Mehra           2013             7               \n\n", outContent.toString());
    }
}
