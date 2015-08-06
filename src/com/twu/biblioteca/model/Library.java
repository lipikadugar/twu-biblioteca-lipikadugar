package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.Objects;

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
                bookDetails += book.toString();
            }
        }
        return bookDetails;
    }

    public boolean checkout(String bookName, User user) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && (book.getStatus())) {
                book.setStatus(false);
                book.setIssuedBy(user.getUserId());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName, User user) {
        for (Book book : books) {
            if (bookName.equals(book.getName()) && !(book.getStatus()) && Objects.equals(user.getUserId(), book.getIssuedId())) {
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
                bookDetails += book.getDetailsAlongWithIssuedBy();
            }
        }
        return bookDetails;
    }

    public String listMovies() {
        String movieDetails = "";
        for (Movie movie : movies) {
            if (movie.getStatus()) {
                movieDetails += movie.toString();
            }
        }
        return movieDetails;
    }

    public boolean checkoutMovie(String movieName, User user) {
        for (Movie movie : movies) {
            if (movieName.equals(movie.getName()) && (movie.getStatus())) {
                movie.setStatus(false);
                movie.setIssuedBy(user.getUserId());
                return true;
            }
        }
        return false;
    }

    public String checkedOutMovieList() {
        String movieDetails = "";
        for (Movie movie : movies) {
            if (!movie.getStatus()) {
                movieDetails += movie.getDetailsAlongWithIssuedBy();
            }
        }
        return movieDetails;
    }

    public boolean returnMovie(String movieName, User user) {
        for (Movie movie : movies) {
            if (movieName.equals(movie.getName()) && !(movie.getStatus()) && Objects.equals(user.getUserId(), movie.getIssuedId())) {
                movie.setStatus(true);
                return true;
            }
        }
        return false;
    }
}