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
}
