package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldCompareTheEqualityOfTwoBooksBasedOnTheirNames() {
        Book book1 = new Book("Java", "Oreilly", 1992, true, "");
        Book book2 = new Book("C++", "Oreilly", 1992, true, "");

        assertNotEquals(true, book1.equals(book2));
    }

    @Test
    public void shouldGiveTheEqualityOfBookNameAndTheBookClass() {
        Book book1 = new Book("Java", "Oreilly", 1992, true, "");
        String book2 = "Java";

        assertEquals(true, book1.equals(book2));
    }

    @Test
    public void shouldDisplayBookDetails() {
        Book book = new Book("Java", "Oreilly", 1992, true, "");

        assertEquals("JAVA                             Oreilly                          1992            \n", book.toString());
    }

    @Test
    public void shouldSetTheIssuedByForTheBook() {
        Book book = new Book("Java", "Oreilly", 1992, true, "");

        book.setIssuedBy("Lisa");

        assertEquals("JAVA                             Oreilly                          1992                         Lisa\n", book.getDetailsAlongWithIssuedBy());
    }
}
