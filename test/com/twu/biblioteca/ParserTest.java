package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Scanner in;

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);
        View view = new View(library, in);

        Parser parse = new Parser(library, view);
        assertEquals(view.getClass(), parse.getClassObject("1").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut(library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkout.getClass(), parse.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn(library, view);

        Parser parse = new Parser(library, view);
        assertEquals(checkIn.getClass(), parse.getClassObject("3").getClass());
    }
}
