package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    ArrayList<Book> books;
    Book bookDetails;
    Library library;

    @Before
    public void setUp() throws Exception {
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
        assertEquals("Book Name                        Author                           Year Published  \n" +
                "\n" +
                "JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailableBook() {
        library.checkout("Java");

        assertEquals("Book Name                        Author                           Year Published  \n" +
                "\n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulCheckout() {
        assertEquals(true, library.checkout("Java"));
    }

    @Test
    public void shouldDisplayMessageWhenBookIsNotAvailable() {
        assertEquals(false, library.checkout("Data Structures"));
    }

    @Test
    public void shouldBeAbleToReturnTheBookToTheLibrary() {
        library.checkout("The Da Vinci Code");
        library.returnBook("The Da Vinci Code");

        assertEquals("Book Name                        Author                           Year Published  \n" +
                "\n" +
                "JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n", library.list());
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        library.checkout("The Da Vinci Code");

        assertEquals(true, library.returnBook("The Da Vinci Code"));
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnFailingToReturn() {
        library.checkout("The Da Vinci Code");

        assertEquals(false, library.returnBook("The Famous Five"));
    }
}
