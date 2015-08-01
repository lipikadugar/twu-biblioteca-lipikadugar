package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("Java");
        when(library.checkout("Java")).thenReturn(true);
        CheckOut checkOut = new CheckOut(library, view);

        checkOut.execute();

        verify(view).printMessage("Enter the book name to checkout: ");
        verify(view).printMessage("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturn() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("The Shadow God");
        when(library.checkout("The Shadow God")).thenReturn(false);
        CheckOut checkOut = new CheckOut(library, view);

        checkOut.execute();

        verify(view).printMessage("Enter the book name to checkout: ");
        verify(view).printMessage("That book is not available.");
    }
}
