package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    ArrayList<Book> books;
    Book bookDetails;
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
        library = new Library(books);
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
    public void shouldDisplayMessageOnSuccessfulCheckout() {
        assertEquals(true, library.checkout("Java".toUpperCase()));
    }

    @Test
    public void shouldDisplayMessageWhenBookIsNotAvailable() {
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
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        library.checkout("The Da Vinci Code".toUpperCase());

        assertEquals(true, library.returnBook("The Da Vinci Code".toUpperCase()));
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnFailingToReturn() {
        library.checkout("The Da Vinci Code".toUpperCase());

        assertEquals(false, library.returnBook("The Famous Five".toUpperCase()));
    }

    @Test
    public void shouldBeAbleListTheCheckedOutBookDetails() {
        books.get(0).setStatus(false);

        assertEquals("JAVA                             Oreilly                          1998            \n", library.checkedOutList());
    }
}
