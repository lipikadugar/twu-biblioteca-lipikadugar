package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void displayTheBooksFromArrayList() {
        ArrayList<String> books = new ArrayList<>(Arrays.asList("Java", "C++", "Data Structures"));
        BookList list = new BookList(books);
        View view = new View();
        books.add("Java");
        books.add("C++");

        view.display(list);

        assertEquals("Java\nC++\nData Structures\n", outContent.toString());
    }
}
