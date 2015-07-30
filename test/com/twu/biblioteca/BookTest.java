package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldCompareTheEqualityOfTwoBooks() {
        Book book1 = new Book("Java", "Oreilly", 1992);
        Book book2 = new Book("Java", "Oreilly", 1992);

        assertEquals(true, book1.equals(book2));
    }

    @Test
    public void shouldCompareTheEqualityOfTwoBooksBasedOnTheirNames() {
        Book book1 = new Book("Java", "Oreilly", 1992);
        Book book2 = new Book("C++", "Oreilly", 1992);

        assertNotEquals(true, book1.equals(book2));
    }
}
