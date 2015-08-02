package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldCompareTheEqualityOfTwoMovies() {
        Movie movie1 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        Movie movie2 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);

        assertEquals(true, movie1.equals(movie2.getName()));
    }
}
