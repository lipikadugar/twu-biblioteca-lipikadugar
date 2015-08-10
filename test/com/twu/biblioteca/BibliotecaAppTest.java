package com.twu.biblioteca;

import com.twu.biblioteca.model.*;
import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.View;
import com.twu.biblioteca.view.WelcomeView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Item> books;
    ArrayList<Item> movies;
    Book bookDetails;
    Movie movieDetails;
    UserAuthentication user;
    Library bookSection;
    Library movieSection;
    Scanner in;
    UserAuthentication librarian;
    WelcomeView welcome;

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
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        View view = new View("1", bookSection, movieSection, in);
        BibliotecaApp app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, user, welcome);

        assertEquals(view.getClass(), app.getClassObject("1").getClass());
    }

    @Test
    public void shouldListTheBookDetailsIfTheOptionIs1() {
        View view = Mockito.mock(View.class);
        BibliotecaApp app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, user, welcome);
        when(view.input()).thenReturn("1");

        Operations operate = app.getClassObject("1");
        operate.execute();

        assertEquals("Book Name                        Author                           Year Published          Issued By\n" +
                "---------                        ------                           --------------          ---------\n" +
                "\n" +
                "JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n" +
                "\n", outContent.toString());
    }
}
