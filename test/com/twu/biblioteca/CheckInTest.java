package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInTest {
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
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("Java");
        when(library.returnBook("Java".toUpperCase())).thenReturn(true);
        CheckIn checkIn = new CheckIn(library, view);

        checkIn.execute();

        verify(view).printMessage("Enter the book name to return: ");
        verify(view).printMessage("Thank you for returning the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturn() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("The Shadow God");
        when(library.returnBook("The Shadow God".toUpperCase())).thenReturn(false);
        CheckIn checkIn = new CheckIn(library, view);

        checkIn.execute();

        verify(view).printMessage("Enter the book name to return: ");
        verify(view).printMessage("That is not a valid book to return.");
    }
}
