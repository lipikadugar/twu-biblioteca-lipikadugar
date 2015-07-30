package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void shouldGiveObjectForAdditionClass() {

        Parser parse = new Parser();
        View view = new View();
        assertEquals(view.getClass(), parse.getClassObject("listBooks").getClass());
    }
}
