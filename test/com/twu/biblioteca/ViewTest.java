package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;
    ArrayList<Book> books;
    Book bookDetails;
    Library library;
    Scanner in;

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
        library = new Library(books);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        View view = new View(library, in);

        view.print("!!..Welcome to the Bibliotica..!!");

        assertEquals("\t!!..Welcome to the Bibliotica..!!\n", outContent.toString());
    }

    @Test
    public void shouldDisplayMenuList() {

        View view = new View(library, in);

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
        View view = new View(library, in);

        view.execute();

        assertEquals("Book Name                        Author                           Year Published  \n" +
                "---------                        ------                           --------------  \n\n" +
                "JAVA                             Oreilly                          1998            \n" +
                "THE DA VINCI CODE                Dan Brown                        2005            \n" +
                "THE FAMOUS FIVE                  Enid Blyton                      1993            \n" +
                "FIVE POINT SOMEONE               Chetan Bhagat                    2010            \n\n", outContent.toString());
    }
}
