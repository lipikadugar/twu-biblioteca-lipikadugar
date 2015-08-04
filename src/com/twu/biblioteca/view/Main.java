package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<User> librarian = new ArrayList<>();

        Book bookDetails = new Book("Java", "Oreilly", 1998, true);
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true);
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true);
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true);
        books.add(bookDetails);

        Movie movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true);
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true);
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true);
        movies.add(movieDetails);

        User userDetails = new User("000-0000", "!abcd0123");
        users.add(userDetails);
        userDetails = new User("000-0001", "!abcd1234");
        users.add(userDetails);

        User librarianDetails = new User("999-999", "biblioteca");
        librarian.add(librarianDetails);
        librarianDetails = new User("999-9998", "biblioteca");
        librarian.add(librarianDetails);

        Scanner in = new Scanner(System.in);
        Library library = new Library(books, movies);
        View view = new View("1", library, in);
        BibliotecaApp app = new BibliotecaApp(view, in, library);
        app.start(true);
    }
}

