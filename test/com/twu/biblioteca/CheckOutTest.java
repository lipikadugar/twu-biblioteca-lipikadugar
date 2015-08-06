package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutTest {

    View view;
    Library bookSection;
    Library movieSection;
    User user;

    @Before
    public void setUp() {
        view = Mockito.mock(View.class);
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        user = Mockito.mock(User.class);
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOut() {
        when(view.input()).thenReturn("Java");
        when(bookSection.checkoutItem("Java".toUpperCase(), user)).thenReturn(true);
        CheckOut checkOut = new CheckOut("2", bookSection, movieSection, view, user);

        checkOut.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOut() {
        when(view.input()).thenReturn("The Shadow God");
        when(bookSection.checkoutItem("The Shadow God".toUpperCase(), user)).thenReturn(false);
        CheckOut checkOut = new CheckOut("2", bookSection, movieSection, view, user);

        checkOut.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("That book is not available.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOutOfMovie() {
        when(view.input()).thenReturn("Men In Black");
        when(movieSection.checkoutItem("Men In Black".toUpperCase(), user)).thenReturn(true);
        CheckOut checkOut = new CheckOut("6", bookSection, movieSection, view, user);

        checkOut.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOutOfMovie() {
        when(view.input()).thenReturn("Spy");
        when(movieSection.checkoutItem("Spy".toUpperCase(), user)).thenReturn(false);
        CheckOut checkOut = new CheckOut("6", bookSection, movieSection, view, user);

        checkOut.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("That movie is not available.");
    }
}
