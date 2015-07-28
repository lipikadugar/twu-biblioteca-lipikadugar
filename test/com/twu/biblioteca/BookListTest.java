package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void shouldDisplayAllTheBooksFromLibrary() {
        BookList list = new BookList("Java");

        assertEquals(Arrays.asList("Java"), list.showBooks());
    }
}
