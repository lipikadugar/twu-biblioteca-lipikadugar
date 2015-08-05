package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true, "");
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
        User user = Mockito.mock(User.class);
        library.checkout("Java", user);

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckout() {
        User user = Mockito.mock(User.class);
        assertEquals(true, library.checkout("Java".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotAvailable() {
        User user = Mockito.mock(User.class);
        assertEquals(false, library.checkout("Data Structures".toUpperCase(), user));
    }

    @Test
    public void shouldBeAbleToReturnTheBookToTheLibrary() {
        User user = Mockito.mock(User.class);
        library.checkout("The Da Vinci Code".toUpperCase(), user);
        library.returnBook("The Da Vinci Code".toUpperCase());

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturn() {
        User user = Mockito.mock(User.class);
        library.checkout("The Da Vinci Code".toUpperCase(), user);

        assertEquals(true, library.returnBook("The Da Vinci Code".toUpperCase()));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnBook() {
        User user = Mockito.mock(User.class);
        library.checkout("The Da Vinci Code".toUpperCase(), user);

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

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckoutMovie() {
        assertEquals(false, library.checkoutMovie("Spy".toUpperCase()));
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailableMovie() {
        library.checkoutMovie("Men In Black".toUpperCase());

        assertEquals("CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                    "3 IDIOTS                         RajKumar Hirani                  2009             9               \n" +
                    "BHAAG MILKHA BHAAG               Rakesh omprakash Mehra           2013             7               \n", library.listMovies());
    }

    @Test
    public void shouldBeAbleListTheCheckedOutMovieDetails() {
        movies.get(1).setStatus(false);
        movies.get(2).setStatus(false);

        assertEquals("CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9               \n", library.checkedOutMovieList());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnOfMovie() {
        library.checkoutMovie("Chak De India".toUpperCase());

        assertEquals(true, library.returnMovie("Chak De India".toUpperCase()));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnMovie() {
        User user = Mockito.mock(User.class);
        library.checkout("Check De India".toUpperCase(), user);

        assertEquals(false, library.returnMovie("Spy".toUpperCase()));
    }
}
