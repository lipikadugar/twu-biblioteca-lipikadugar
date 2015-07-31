package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);

        Parser parse = new Parser(library);
        View view = new View(library);
        assertEquals(view.getClass(), parse.getClassObject("1").getClass());
    }
}
