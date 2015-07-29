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

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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
                "\t2. Quit\n" +
                "=========================================\n" +
                "Choose a option: \n", outContent.toString());
    }

    @Test
    public void shouldDisplayDetailsOfAllTheBook() {
        ArrayList<HashMap> books = new ArrayList<>();

        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        books.add(book2);

        View view = new View();

        view.displayDetails(books);

        assertEquals("Java | Oreilly | 1998\n" +
                "The Da Vinci Code | Dan Brown | 2001\n", outContent.toString());
    }
}
