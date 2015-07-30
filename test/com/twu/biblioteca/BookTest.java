package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void compareTheEqualityOfTwoBooks() {
        Book book1 = new Book("Java", "Oreilly", 1992);
        Book book2 = new Book("Java", "Oreilly", 1992);

        assertEquals(true, book1.equals(book2));
    }
}
