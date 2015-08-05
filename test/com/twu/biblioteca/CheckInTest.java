package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInTest {

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturn() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        User user = Mockito.mock(User.class);
        when(view.input()).thenReturn("Java");
        when(library.returnBook("Java".toUpperCase(), user)).thenReturn(true);
        CheckIn checkIn = new CheckIn("3", library, view, user);

        checkIn.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("Thank you for returning the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturn() {
        View view = Mockito.mock(View.class);
        User user = Mockito.mock(User.class);
        Library library = Mockito.mock(Library.class);
        when(view.input()).thenReturn("The Shadow God");
        when(library.returnBook("The Shadow God".toUpperCase(), user)).thenReturn(false);
        CheckIn checkIn = new CheckIn("3", library, view, user);

        checkIn.execute();

        verify(view).print("Enter the book name: ");
        verify(view).print("That is not a valid book to return.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnSuccessfulReturnMovie() {
        View view = Mockito.mock(View.class);
        User user = Mockito.mock(User.class);
        Library library = Mockito.mock(Library.class);
        when(view.input()).thenReturn("Men In Black");
        when(library.returnMovie("Men In Black".toUpperCase())).thenReturn(true);
        CheckIn checkIn = new CheckIn("8", library, view, user);

        checkIn.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("Thank you for returning the movie.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturnOfMovie() {
        View view = Mockito.mock(View.class);
        User user = Mockito.mock(User.class);
        Library library = Mockito.mock(Library.class);
        when(view.input()).thenReturn("Spy");
        when(library.returnBook("Spy".toUpperCase(), user)).thenReturn(false);
        CheckIn checkIn = new CheckIn("8", library, view, user);

        checkIn.execute();

        verify(view).print("Enter the movie name: ");
        verify(view).print("That is not a valid movie to return.");
    }
}
