package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    ArrayList<Book> books;
    ArrayList<Movie> movies;
    Book bookDetails;
    Movie movieDetails;
    Library library;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true);
        books.add(bookDetails);

        movies = new ArrayList<>();
        movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true);
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true);
        movies.add(movieDetails);
        library = new Library(books, movies);
    }

    @Test
    public void shouldListTheBookDetailsStoredInLibrary() {
        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailableBook() {
        library.checkout("Java");

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckout() {
        assertEquals(true, library.checkout("Java".toUpperCase()));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotAvailable() {
        assertEquals(false, library.checkout("Data Structures".toUpperCase()));
    }

    @Test
    public void shouldBeAbleToReturnTheBookToTheLibrary() {
        library.checkout("The Da Vinci Code".toUpperCase());
        library.returnBook("The Da Vinci Code".toUpperCase());

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturn() {
        library.checkout("The Da Vinci Code".toUpperCase());

        assertEquals(true, library.returnBook("The Da Vinci Code".toUpperCase()));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnBook() {
        library.checkout("The Da Vinci Code".toUpperCase());

        assertEquals(false, library.returnBook("The Famous Five".toUpperCase()));
    }

    @Test
    public void shouldBeAbleListTheCheckedOutBookDetails() {
        books.get(0).setStatus(false);

        assertEquals("JAVA                             Oreilly                          1998            \n", library.checkedOutList());
    }

    @Test
    public void shouldListTheMovieDetailsStoredInLibrary() {
        assertEquals("MEN IN BLACK                     Barry Sonnenfeld                 1997             7               \n" +
                "CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9               \n" +
                "BHAAG MILKHA BHAAG               Rakesh omprakash Mehra           2013             7               \n", library.listMovies());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckoutMovie() {
        assertEquals(true, library.checkoutMovie("Men In Black".toUpperCase()));
    }
}
