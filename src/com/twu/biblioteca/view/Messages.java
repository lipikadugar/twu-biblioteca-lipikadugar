package com.twu.biblioteca.view;

public interface Messages {
    String LOGIN_MENU = "=========================================\n" +
            "\t1. List Books\n" +
            "\t2. List Movies\n" +
            "\t3. Login as Librarian\n" +
            "\t4. Login as User\n" +
            "\t5. Quit\n" +
            "=========================================\n" +
            "Choose a option: \n";
    String MENU_FOR_LIBRARIAN = "=========================================\n\t\tMenu\n" +
            "\t1. List Book Details\n" +
            "\t2. Checkout\n" +
            "\t3. Return Book\n" +
            "\t4. List Checked Out Books\n" +
            "\t5. List Movie Details\n" +
            "\t6. Checkout Movie\n" +
            "\t7. List Checked Out Movies\n" +
            "\t8. Return Movie\n" +
            "\t9. Logout\n" +
            "=========================================\n" +
            "Choose a option: ";
    String MENU_FOR_USER = "=========================================\n\t\tMenu\n" +
            "\t1. List Book Details\n" +
            "\t2. Checkout Book\n" +
            "\t3. Return Book\n" +
            "\t4. List Movie Details\n" +
            "\t5. Checkout Movie\n" +
            "\t6. Return Movie\n" +
            "\t7. My Profile\n" +
            "\t8. Logout\n" +
            "=========================================\n" +
            "Choose a option: \n";
    String ERROR_MESSAGE = "Select a valid option!";
    String WELCOME_MESSAGE = "\t!!..Welcome to the Bibliotica..!!";
    String USER_ID = "Enter user ID : ";
    String PASSWORD = "Enter Password: ";
    String PROMPT_BOOK_NAME = "Enter the book name: ";
    String SUCCESSFUL_BOOK_CHECKIN = "Thank you for returning the book.";
    String UNSUCCESSFUL_BOOK_CHECKIN = "That is not a valid book to return.";
    String PROMPT_MOVIE_NAME = "Enter the movie name: ";
    String SUCCESSFUL_MOVIE_CHECKIN = "Thank you for returning the movie.";
    String UNSUCCESSFUL_MOVIE_CHECKIN = "That is not a valid movie to return.";
    String SUCCESSFUL_BOOK_CHECKOUT = "Thank you! Enjoy the book.";
    String UNSUCCESSFUL_BOOK_CHECKOUT = "That book is not available.";
    String SUCCESSFUL_MOVIE_CHECKOUT = "Thank you! Enjoy the movie.";
    String UNSUCCESSFUL_MOVIE_CHECKOUT = "That movie is not available.";
    String INVALID_USER = "The userID and password does not match. Try again.";
}
