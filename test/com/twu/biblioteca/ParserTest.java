package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {

        Parser parse = new Parser();
        View view = new View();
        assertEquals(view.getClass(), parse.getClassObject("listBooks").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Parser parse = new Parser();
        Checkout checkout = new Checkout();
        assertEquals(checkout.getClass(), parse.getClassObject("checkout").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        Parser parse = new Parser();
        CheckIn checkIn = new CheckIn();
        assertEquals(checkIn.getClass(), parse.getClassObject("checkin").getClass());
    }

    @Test
    public void shouldGiveObjectForQuitClassIfOptionIsQuit() {
        Parser parse = new Parser();
        QuitApp quit = new QuitApp();
        assertEquals(quit.getClass(), parse.getClassObject("quit").getClass());
    }
}
