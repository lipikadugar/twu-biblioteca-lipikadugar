package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Item> books;
    private ArrayList<Item> movies;
    private ArrayList<Item> items;

    public Library(ArrayList<Item> books, ArrayList<Item> movies) {
        this.books = books;
        this.movies = movies;
    }

    public Library(ArrayList<Item> items) {
        this.items = items;
    }

    public String list() {
        String bookDetails = "";
        for (Item book : books) {
            if (book.getStatus()) {
                bookDetails += book.toString();
            }
        }
        return bookDetails;
    }

    public boolean checkout(String bookName, User user) {
        for (Item book : books) {
            if (bookName.equals(book.getName()) && (book.getStatus())) {
                book.setStatus(false);
                book.setIssuedBy(user.getUserId());
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName, User user) {
        for (Item book : books) {
            if (bookName.equals(book.getName()) && !(book.getStatus()) && Objects.equals(user.getUserId(), book.getIssuedId())) {
                book.setStatus(true);
                return true;
            }
        }
        return false;
    }

    public String checkedOutList() {
        String bookDetails = "";
        for (Item book : books) {
            if (!book.getStatus()) {
                bookDetails += book.getDetailsAlongWithIssuedBy();
            }
        }
        return bookDetails;
    }

    public String listMovies() {
        String movieDetails = "";
        for (Item movie : movies) {
            if (movie.getStatus()) {
                movieDetails += movie.toString();
            }
        }
        return movieDetails;
    }

    public boolean checkoutMovie(String movieName, User user) {
        for (Item movie : movies) {
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
        for (Item movie : movies) {
            if (!movie.getStatus()) {
                movieDetails += movie.getDetailsAlongWithIssuedBy();
            }
        }
        return movieDetails;
    }

    public boolean returnMovie(String movieName, User user) {
        for (Item movie : movies) {
            if (movieName.equals(movie.getName()) && !(movie.getStatus()) && Objects.equals(user.getUserId(), movie.getIssuedId())) {
                movie.setStatus(true);
                return true;
            }
        }
        return false;
    }

    public String listItemDetails() {
        String itemDetails = "";
        for (Item item : items) {
            if (item.getStatus()) {
                itemDetails += item.toString();
            }
        }
        return itemDetails;
    }

    public boolean checkoutItem(String itemName, User user) {
        for (Item item : items) {
            if (itemName.equals(item.getName()) && (item.getStatus())) {
                item.setStatus(false);
                item.setIssuedBy(user.getUserId());
                return true;
            }
        }
        return false;
    }

    public boolean returnItem(String itemName, User user) {
        for (Item item : items) {
            if (itemName.equals(item.getName()) && !(item.getStatus()) && Objects.equals(user.getUserId(), item.getIssuedId())) {
                item.setStatus(true);
                return true;
            }
        }
        return false;
    }

    public String checkedOutItemList() {
        String itemDetails = "";
        for (Item item : items) {
            if (!item.getStatus()) {
                itemDetails += item.getDetailsAlongWithIssuedBy();
            }
        }
        return itemDetails;
    }
}