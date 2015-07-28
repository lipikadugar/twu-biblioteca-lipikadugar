package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        String[][] bookDetails = new String[][] {{"Java", "Oreilly", "1992"}, {"C++", "Kanetkar", "1998"},
                {"Data Structures", "Kent", "2005"}};
        BookList list = new BookList(bookDetails);
        View view = new View();

        view.display(list);

        assertEquals("Java\nC++\nData Structures\n", outContent.toString());
    }

    @Test
    public void displayDetailsOfTheBook() {
        String[][] bookDetails = new String[][] {{"Java", "Oreilly", "1992"}, {"C++", "Kanetkar", "1998"},
                {"Data Structures", "Kent", "2005"}};
        BookList list = new BookList(bookDetails);
        View view = new View();

        view.displayDetails(list);

        assertEquals("Java \t Oreilly \t 1992\n" + "C++ \t Kanetkar \t 1998\n" + "Data Structures \t Kent \t 2005\n", outContent.toString());
    }
}
