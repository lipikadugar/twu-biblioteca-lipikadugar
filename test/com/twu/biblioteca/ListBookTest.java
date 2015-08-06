package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

public class ListBookTest {

    ArrayList<Item> books;
    ArrayList<Item> movies;
    Book bookDetails;
    private Library library;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, false, "Lisa");
        books.add(bookDetails);

        movies = new ArrayList<>();
        Movie movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true, "");
        movies.add(movieDetails);

        library = new Library(books, movies);
    }

    @Test
    public void shouldListTheAllBooksInTheLibrary() {
        View view = Mockito.mock(View.class);
        ListCheckedOutItem list = new ListCheckedOutItem("4", library, view);

        list.execute();

        verify(view).print("FIVE POINT SOMEONE               Chetan Bhagat                    2010                         Lisa\n");
    }
}
