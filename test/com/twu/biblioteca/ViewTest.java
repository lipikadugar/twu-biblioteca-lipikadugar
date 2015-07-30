package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Book> books;
    Book bookDetails;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        books = new ArrayList<>();
        bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true);
        books.add(bookDetails);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        View view = new View();

        view.welcomeMessage();

        assertEquals("\t!!..Welcome to the Bibliotica..!!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMenuList() {
        View view = new View();

        view.displayMenu();

        assertEquals("=========================================\n" +
                "\t\tMenu\n" +
                "\t1. List Book Details\n" +
                "\t2. Checkout\n" +
                "\t3. Return Book\n" +
                "\t4. Quit\n" +
                "=========================================\n" +
                "Choose a option: \n", outContent.toString());
    }

    @Test
    public void shouldDisplayDetailsOfAllTheBook() {
        Library library = new Library(books);
        View view = new View();
        String book = library.list();

        assertEquals(book, view.displayDetails(library));
    }
}
