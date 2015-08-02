package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class ListCheckedOutItemTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Book> books;
    ArrayList<Movie> movies;
    Book bookDetails;
    Movie movieDetails;
    Library library;
    Scanner in;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, false);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, false);
        books.add(bookDetails);
    }

    @Test
    public void shouldListCheckedOutBookList() {
        Library library = new Library(books, movies);
        View view = new View("4", library, in);
        ListCheckedOutItem item = new ListCheckedOutItem("4", library, view);

        item.execute();

        assertEquals("\tTHE DA VINCI CODE                Dan Brown                        2005            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n" +
                "\n", outContent.toString());
    }
}
