package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInTest {

    Library bookSection;
    Library movieSection;
    View view;
    User user;

    @Before
    public void setUp() {
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        view = Mockito.mock(View.class);
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        when(view.input()).thenReturn("Java");
        when(bookSection.returnItem("Java".toUpperCase(), user)).thenReturn(true);
        CheckIn checkIn = new CheckIn("3", bookSection, movieSection, view, user);

        checkIn.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("Thank you for returning the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturn() {
        when(view.input()).thenReturn("The Shadow God");
        when(bookSection.returnItem("The Shadow God".toUpperCase(), user)).thenReturn(false);
        CheckIn checkIn = new CheckIn("3", bookSection, movieSection, view, user);

        checkIn.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("That is not a valid book to return.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturnMovie() {
        when(view.input()).thenReturn("Men In Black");
        when(movieSection.returnItem("Men In Black".toUpperCase(), user)).thenReturn(true);
        CheckIn checkIn = new CheckIn("8", bookSection, movieSection, view, user);

        checkIn.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("Thank you for returning the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturnOfMovie() {
        when(view.input()).thenReturn("Spy");
        when(movieSection.returnItem("Spy".toUpperCase(), user)).thenReturn(false);
        CheckIn checkIn = new CheckIn("8", bookSection, movieSection, view, user);

        checkIn.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("That is not a valid movie to return.");
    }
}
