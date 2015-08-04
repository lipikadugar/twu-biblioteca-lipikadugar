package com.twu.biblioteca;

import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {

    @Test
    public void shouldCompareTheEqualityOfTwoMovies() {
        Movie movie1 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        Movie movie2 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);

        assertEquals(true, movie1.equals(movie2.getName()));
    }

    @Test
    public void shouldCompareTheEqualityOfTwoMoviesBasedOnTheirNames() {
        Movie movie1 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        Movie movie2 = new Movie("Bajrangi BhaiJaan", "Kabir Khan", 2015, 8, true);

        assertNotEquals(true, movie1.equals(movie2));
    }

    @Test
    public void shouldGiveTheEqualityOfMovieNameAndTheMovieClass() {
        Movie movie1 = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        String movie2 = "Men In Black";

        assertEquals(true, movie1.equals(movie2));
    }

    @Test
    public void shouldDisplayMovieDetails() {
        Movie movie = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);

        assertEquals("MEN IN BLACK                     Barry Sonnenfeld                 1997             7               \n", movie.toString());
    }
}
