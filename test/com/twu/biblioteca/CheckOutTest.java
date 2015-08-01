package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckOutTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream defaultOutStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(defaultOutStream);
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        Library library = Mockito.mock(Library.class);
        View view = new View(library);
        CheckOut checkOut = new CheckOut(library, view);

        checkOut.execute();

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }
}
