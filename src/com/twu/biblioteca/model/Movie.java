package com.twu.biblioteca.model;

public class Movie {
    private String movieName;
    private String director;
    private int releaseYear;
    private int rating;
    private boolean status;

    public Movie(String bookName, String author, int yearPublished, int rating, boolean status) {
        this.movieName = bookName.toUpperCase();
        this.director = author;
        this.releaseYear = yearPublished;
        this.rating = rating;
        this.status = status;
    }

    public boolean equals(String thatMovie) {
        return movieName.equals(thatMovie.toUpperCase());
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return movieName.toUpperCase();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%-32s %-32s %-16s %-16s\n", movieName, director, releaseYear, rating);
    }
}
