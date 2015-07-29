package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void shouldListAllTheBookNamesStoredInLibrary() {
        ArrayList<HashMap> books = new ArrayList<>();
        HashMap book1 = new HashMap();
        HashMap book2 = new HashMap();

        book1.put("bookId", 1);
        book1.put("bookName", "Java");
        book1.put("author", "Oreilly");
        book1.put("yearPublished", 1998);
        books.add(book1);

        book2.put("bookId", 2);
        book2.put("bookName", "The Da Vinci Code");
        book2.put("author", "Dan Brown");
        book2.put("yearPublished", 2001);
        books.add(book2);

        Library library = new Library(books);

        assertEquals("Java | The Da Vinci Code", library.list());
    }
}
