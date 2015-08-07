package com.twu.biblioteca.model;

public class Movie implements Item{
    private String issuedBy;
    private String movieName;
    private String director;
    private int releaseYear;
    private int rating;
    private boolean status;

    public Movie(String movieName, String author, int yearPublished, int rating, boolean status, String issuedBy) {
        this.issuedBy = issuedBy;
        this.movieName = getUpperCase(movieName);
        this.director = author;
        this.releaseYear = yearPublished;
        this.rating = rating;
        this.status = status;
    }

    @Override
    public boolean equals(String thatMovie) {
        return movieName.equals(getUpperCase(thatMovie));
    }

    public String getUpperCase(String thatMovie) {
        return thatMovie.toUpperCase();
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Override
    public String getDetailsAlongWithIssuedBy() {
        return String.format("%-32s %-32s %-16s %-16s %16s\n",
                movieName, director, releaseYear, rating, issuedBy);
    }

    @Override
    public String getIssuedId() {
        return issuedBy;
    }

    @Override
    public String toString() {
        return String.format("%-32s %-32s %-16s %-16s\n", movieName, director, releaseYear, rating);
    }
}
