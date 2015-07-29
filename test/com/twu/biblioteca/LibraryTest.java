package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldListTheBookDetailsStoredInLibrary() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "available");
        books.add(book2);

        Library library = new Library(books);

        assertEquals("Java | Oreilly | 1998\n" +
                "The Da Vinci Code | Dan Brown | 2001\n", library.list());
    }

    @Test
    public void shouldBeAbleToCheckoutAnAvailableBook() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "available");
        books.add(book2);

        Library library = new Library(books);
        library.checkout("Java");

        assertEquals("The Da Vinci Code | Dan Brown | 2001\n", library.list());
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulCheckout() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "available");
        books.add(book2);

        Library library = new Library(books);

        assertEquals("Thank you! Enjoy the book", library.checkout("Java"));
    }

    @Test
    public void shouldDisplayMessageWhenBookIsNotAvailable() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "available");
        books.add(book2);

        Library library = new Library(books);

        assertEquals("That book is not available.", library.checkout("The Famous Five"));
    }

    @Test
    public void shouldBeAbleToReturnTheBookToTheLibrary() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "unavailable");
        books.add(book2);

        Library library = new Library(books);
        library.returnBook("The Da Vinci Code");

        assertEquals("Java | Oreilly | 1998\n" +
                "The Da Vinci Code | Dan Brown | 2001\n", library.list());
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "unavailable");
        books.add(book2);

        Library library = new Library(books);

        assertEquals("Thank you for returning the book.", library.returnBook("The Da Vinci Code"));
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnFailingToReturn() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        book1.put("availability", "available");
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        book2.put("availability", "unavailable");
        books.add(book2);

        Library library = new Library(books);

        assertEquals("That is not a valid book to return.", library.returnBook("The Famous Five"));
    }
}
