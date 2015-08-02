package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.*;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Scanner in;

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);
        View view = new View("1", library, in);

        Parser parse = new Parser(library, view);
        assertEquals(view.getClass(), parse.getClassObject("1").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("2", library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkout.getClass(), parse.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("3", library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkIn.getClass(), parse.getClassObject("3").getClass());
    }

    @Test
    public void shouldGiveObjectForQuitClassIfOptionIsQuit() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        Parser parse = new Parser(library, view);
        QuitApp quit = new QuitApp();
        assertEquals(quit.getClass(), parse.getClassObject("9").getClass());
    }

    @Test
    public void shouldGiveObjectForListBookClassIfOptionIsListCheckedOutBooks() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        Parser parse = new Parser(library, view);
        ListCheckedOutItem list = new ListCheckedOutItem("4", library, view);
        assertEquals(list.getClass(), parse.getClassObject("4").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListMovieDetails() {
        Library library = Mockito.mock(Library.class);
        View view = new View("5", library, in);

        Parser parse = new Parser(library, view);
        assertEquals(view.getClass(), parse.getClassObject("5").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOutMovies() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("6", library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkout.getClass(), parse.getClassObject("6").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckedOutItemClassIfOptionIsListCheckedOutMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        Parser parse = new Parser(library, view);
        ListCheckedOutItem list = new ListCheckedOutItem("7", library, view);
        assertEquals(list.getClass(), parse.getClassObject("7").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckInMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("8", library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkIn.getClass(), parse.getClassObject("8").getClass());
    }
}
