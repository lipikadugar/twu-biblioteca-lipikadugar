package com.twu.biblioteca;

import com.twu.biblioteca.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    ArrayList<Item> books;
    ArrayList<Item> movies;
    Book bookDetails;
    Movie movieDetails;
    Library library;
    User user;
    Library bookSection;
    Library movieSection;

    @Before
    public void setUp() {
        user = Mockito.mock(User.class);
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true, "");
        books.add(bookDetails);
        bookSection = new Library(books);

        movies = new ArrayList<>();
        movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true, "");
        movies.add(movieDetails);
        movieSection = new Library(movies);

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
        library.checkout("Java", user);

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckout() {
        assertEquals(true, library.checkout("Java".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotAvailable() {
        assertEquals(false, library.checkout("Data Structures".toUpperCase(), user));
    }

    @Test
    public void shouldBeAbleToReturnTheBookToTheLibrary() {
        library.checkout("The Da Vinci Code".toUpperCase(), user);
        library.returnBook("The Da Vinci Code".toUpperCase(), user);

        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturn() {
        library.checkout("The Da Vinci Code".toUpperCase(), user);

        assertEquals(true, library.returnBook("The Da Vinci Code".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnBook() {
        library.checkout("The Da Vinci Code".toUpperCase(), user);

        assertEquals(false, library.returnBook("The Famous Five".toUpperCase(), user));
    }

    @Test
    public void shouldBeAbleListTheCheckedOutBookDetails() {
        books.get(0).setStatus(false);
        books.get(0).setIssuedBy("Lisa");

        assertEquals("JAVA                             Oreilly                          1998                         Lisa\n", library.checkedOutList());
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
        assertEquals(true, library.checkoutMovie("Men In Black".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckoutMovie() {
        assertEquals(false, library.checkoutMovie("Spy".toUpperCase(), user));
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailableMovie() {
        library.checkoutMovie("Men In Black".toUpperCase(), user);

        assertEquals("CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9               \n" +
                "BHAAG MILKHA BHAAG               Rakesh omprakash Mehra           2013             7               \n", library.listMovies());
    }

    @Test
    public void shouldBeAbleListTheCheckedOutMovieDetails() {
        movies.get(1).setStatus(false);
        movies.get(2).setStatus(false);
        movies.get(1).setIssuedBy("Lisa");
        movies.get(2).setIssuedBy("Nancy");

        assertEquals("CHAK DE INDIA                    Shimit Amin                      2007             8                            Lisa\n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9                           Nancy\n", library.checkedOutMovieList());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnOfMovie() {
        library.checkoutMovie("Chak De India".toUpperCase(), user);

        assertEquals(true, library.returnMovie("Chak De India".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnMovie() {
        library.checkout("Check De India".toUpperCase(), user);

        assertEquals(false, library.returnMovie("Spy".toUpperCase(), user));
    }

    @Test
    public void shouldListTheBookDetails() {
        assertEquals("JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", bookSection.listItemDetails());
    }

    @Test
    public void shouldListTheMovieDetails() {
        assertEquals("MEN IN BLACK                     Barry Sonnenfeld                 1997             7               \n" +
                "CHAK DE INDIA                    Shimit Amin                      2007             8               \n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9               \n" +
                "BHAAG MILKHA BHAAG               Rakesh omprakash Mehra           2013             7               \n", movieSection.listItemDetails());
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckoutOfBook() {
        assertEquals(true, bookSection.checkoutItem("Java".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotAvailableInTheLibrary() {
        assertEquals(false, bookSection.checkoutItem("Data Structures".toUpperCase(), user));
    }

    @Test
    public void shouldReturnTrueOnSuccessfulCheckoutOfMovie() {
        assertEquals(true, movieSection.checkoutItem("Men In Black".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnUnSuccessfulCheckoutOfMovie() {
        assertEquals(false, movieSection.checkoutItem("Spy".toUpperCase(), user));
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnABook() {
        library.checkout("The Da Vinci Code".toUpperCase(), user);

        assertEquals(true, bookSection.returnItem("The Da Vinci Code".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnABook() {
        library.checkout("The Da Vinci Code".toUpperCase(), user);

        assertEquals(false, bookSection.returnItem("The Famous Five".toUpperCase(), user));
    }

    @Test
    public void shouldReturnTrueOnSuccessfulReturnOfAMovie() {
        library.checkoutMovie("Chak De India".toUpperCase(), user);

        assertEquals(true, movieSection.returnItem("Chak De India".toUpperCase(), user));
    }

    @Test
    public void shouldReturnFalseOnFailingToReturnAMovie() {
        library.checkout("Check De India".toUpperCase(), user);

        assertEquals(false, movieSection.returnItem("Spy".toUpperCase(), user));
    }

    @Test
    public void shouldBeAbleListTheDetailsOfCheckedOutMovies() {
        movies.get(1).setStatus(false);
        movies.get(2).setStatus(false);
        movies.get(1).setIssuedBy("Lisa");
        movies.get(2).setIssuedBy("Nancy");

        assertEquals("CHAK DE INDIA                    Shimit Amin                      2007             8                            Lisa\n" +
                "3 IDIOTS                         RajKumar Hirani                  2009             9                           Nancy\n",
                movieSection.checkedOutItemList());
    }

    @Test
    public void shouldBeAbleListTheDetailsOfCheckedOutBooks() {
        books.get(0).setStatus(false);
        books.get(0).setIssuedBy("Lisa");

        assertEquals("JAVA                             Oreilly                          1998                         Lisa\n",
                bookSection.checkedOutItemList());
    }
}
