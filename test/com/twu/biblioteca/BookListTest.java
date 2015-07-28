package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void shouldDisplayABookStoredInLibrary() {
        ArrayList<String> books = new ArrayList<>(Arrays.asList("Java"));
        BookList list = new BookList(books);

        assertEquals(Arrays.asList("Java"), list.showBooks());
    }

    @Test
    public void shouldDisplayAllTheBooksFromTheLibrary() {
        ArrayList<String> books = new ArrayList<>(Arrays.asList("Java", "C++", "Data Structures"));
        BookList list = new BookList(books);

        assertEquals(Arrays.asList("Java", "C++", "Data Structures"), list.showBooks());
    }
}
