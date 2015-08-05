package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutTest {

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOut() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        User user = Mockito.mock(User.class);
        when(view.input()).thenReturn("Java");
        when(library.checkout("Java".toUpperCase(), user)).thenReturn(true);
        CheckOut checkOut = new CheckOut("2", library, view, user);

        checkOut.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOut() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        User user = Mockito.mock(User.class);
        when(view.input()).thenReturn("The Shadow God");
        when(library.checkout("The Shadow God".toUpperCase(), user)).thenReturn(false);
        CheckOut checkOut = new CheckOut("2", library, view, user);

        checkOut.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("That book is not available.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulCheckOutOfMovie() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        User user = Mockito.mock(User.class);
        when(view.input()).thenReturn("Men In Black");
        when(library.checkoutMovie("Men In Black".toUpperCase(), user)).thenReturn(true);
        CheckOut checkOut = new CheckOut("6", library, view, user);

        checkOut.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("Thank you! Enjoy the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulCheckOutOfMovie() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        User user = Mockito.mock(User.class);
        when(view.input()).thenReturn("Spy");
        when(library.checkout("Spy".toUpperCase(), user)).thenReturn(false);
        CheckOut checkOut = new CheckOut("6", library, view, user);

        checkOut.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("That movie is not available.");
    }
}
