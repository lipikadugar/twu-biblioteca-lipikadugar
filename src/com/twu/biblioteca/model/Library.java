package com.twu.biblioteca.model;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public String list() {
        String bookDetails = "";
        for (Book book : books) {
            if (book.getStatus()) {
                String bookName = book.getName();
                String author = book.getAuthor();
                Integer yearPublished = book.getYearPublished();
                bookDetails += String.format("%-32s %-32s %-16s\n", bookName, author, yearPublished);
            }
        }
        return bookDetails;
    }

    public boolean checkout(String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && (book.getStatus())) {
                book.setStatus(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && !(book.getStatus())) {
                book.setStatus(true);
                return true;
            }
        }
        return false;
    }

    public String checkedOutList() {
        String bookDetails = "";
        for (Book book : books) {
            if (!book.getStatus()) {
                String bookName = book.getName();
                String author = book.getAuthor();
                Integer yearPublished = book.getYearPublished();
                bookDetails += String.format("%-32s %-32s %-16s\n", bookName, author, yearPublished);
            }
        }
        return bookDetails;
    }

    public String listMovies() {
        String movieDetails = "";
        for (Movie movie : movies) {
            if (movie.getStatus()) {
                String movieName = movie.getName();
                String director = movie.getDirector();
                Integer releasedYear = movie.getReleaseYear();
                Integer rating = movie.getRating();
                movieDetails += String.format("%-32s %-32s %-16s %-16s\n", movieName, director, releasedYear, rating);
            }
        }
        return movieDetails;
    }
}