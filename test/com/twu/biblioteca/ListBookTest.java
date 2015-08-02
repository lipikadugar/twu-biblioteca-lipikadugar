package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.verify;

public class ListBookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Book> books;
    ArrayList<Movie> movies;
    Book bookDetails;
    private Library library;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, false);
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
    public void shouldListTheAllBooksInTheLibrary() {
        View view = Mockito.mock(View.class);
        ListCheckedOutItem list = new ListCheckedOutItem(library, view);

        list.execute();

        verify(view).print("FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n");
    }
}
