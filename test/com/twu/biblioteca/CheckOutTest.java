package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.view.View;
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
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOut() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("Java");
        when(library.checkout("Java".toUpperCase())).thenReturn(true);
        CheckOut checkOut = new CheckOut("2", library, view);

        checkOut.execute();

        verify(view).print("Enter the book name to checkout: ");
        verify(view).print("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOut() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("The Shadow God");
        when(library.checkout("The Shadow God".toUpperCase())).thenReturn(false);
        CheckOut checkOut = new CheckOut("2", library, view);

        checkOut.execute();

        verify(view).print("Enter the book name to checkout: ");
        verify(view).print("That book is not available.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOutOfMovie() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("Men In Black");
        when(library.checkout("Men In Black".toUpperCase())).thenReturn(true);
        CheckOut checkOut = new CheckOut("6", library, view);

        checkOut.execute();

        verify(view).print("Enter the movie name to checkout: ");
        verify(view).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOutOfMovie() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("Spy");
        when(library.checkout("Spy".toUpperCase())).thenReturn(false);
        CheckOut checkOut = new CheckOut("6", library, view);

        checkOut.execute();

        verify(view).print("Enter the movie name to checkout: ");
        verify(view).print("That movie is not available.");
    }

}
