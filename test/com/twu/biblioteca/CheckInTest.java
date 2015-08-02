package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
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
        when(view.inputBook()).thenReturn("Java");
        when(library.returnBook("Java".toUpperCase())).thenReturn(true);
        CheckIn checkIn = new CheckIn(library, view);

        checkIn.execute();

        verify(view).print("Enter the book name to return: ");
        verify(view).print("Thank you for returning the book.");
    }

    @Test
    public void shouldBeAbleToDisplayAMessageOnUnSuccessfulReturn() {
        View view = Mockito.mock(View.class);
        Library library = Mockito.mock(Library.class);
        when(view.inputBook()).thenReturn("The Shadow God");
        when(library.returnBook("The Shadow God".toUpperCase())).thenReturn(false);
        CheckIn checkIn = new CheckIn(library, view);

        checkIn.execute();

        verify(view).print("Enter the book name to return: ");
        verify(view).print("That is not a valid book to return.");
    }
}
