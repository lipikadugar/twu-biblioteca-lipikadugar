package com.twu.biblioteca.view;

import com.twu.biblioteca.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        ArrayList<User> customers = new ArrayList<>();
        ArrayList<User> librarians = new ArrayList<>();

        ArrayList<Item> books = new ArrayList<>();
        ArrayList<Item> movies = new ArrayList<>();

        Book bookDetails = new Book("Java", "Oreilly", 1998, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Da Vinci Code", "Dan Brown", 2005, true, "");
        books.add(bookDetails);
        bookDetails = new Book("The Famous Five", "Enid Blyton", 1993, true, "");
        books.add(bookDetails);
        bookDetails = new Book("Five Point Someone", "Chetan Bhagat", 2010, true, "");
        books.add(bookDetails);
        Library bookSection = new Library(books);

        Movie movieDetails = new Movie("Men In Black", "Barry Sonnenfeld", 1997, 7, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Chak De India", "Shimit Amin", 2007, 8, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("3 Idiots", "RajKumar Hirani", 2009, 9, true, "");
        movies.add(movieDetails);
        movieDetails = new Movie("Bhaag Milkha Bhaag", "Rakesh omprakash Mehra", 2013, 7, true, "");
        movies.add(movieDetails);
        Library movieSection = new Library(movies);

        User userDetails = new User("000-0000", "!abcd0123", "Lisa", "lisa@gmail.com", "7890678341");
        customers.add(userDetails);
        userDetails = new User("000-0001", "!abcd1234", "Maxell", "mxell@yahoo.com", "9834509291");
        customers.add(userDetails);

        User librarianDetails = new User("999-9999", "biblioteca", "Lipika", "lipikadugar@gmail.com", "9492376517");
        librarians.add(librarianDetails);
        librarianDetails = new User("999-9998", "biblioteca", "Yasmin", "yasmin@gmail.com", "7431348475");
        librarians.add(librarianDetails);

        Scanner in = new Scanner(System.in);
        UserAuthentication librarian = new UserAuthentication(librarians);
        UserAuthentication customer = new UserAuthentication(customers);
        View view = new View("1", bookSection, movieSection, in);
        BibliotecaApp app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, customer);
        app.start(true);
    }
}

