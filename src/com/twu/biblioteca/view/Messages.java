package com.twu.biblioteca.view;

public interface Messages {
    String MENU_FOR_LIBRARIAN = "=========================================\n\t\tMenu\n" +
            "\t1. List Book Details\n" +
            "\t2. Checkout\n" +
            "\t3. Return Book\n" +
            "\t4. List Checked Out Books\n" +
            "\t5. List Movie Details\n" +
            "\t6. Checkout Movie\n" +
            "\t7. List Checked Out Movies\n" +
            "\t8. Return Movie\n" +
            "\t9. My Profile\n" +
            "\t10. Logout\n" +
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
    String MOVIE_HEADER = String.format("%-32s %-32s %-16s %16s %16s\n%-32s %-32s %-16s %16s %16s\n",
            "Movie Name", "Director", "Release Year", "Rating", "Issued By",
            "----------", "--------", "------------", "-------", "---------");
    String BOOK_HEADER = String.format("%-32s %-32s %-16s %32s\n%-32s %-32s %-16s %32s\n",
            "Book Name", "Author", "Year Published", "Issued By",
            "---------", "------", "--------------", "---------");
    String BOOK_DETAILS_HEADER = String.format("%-32s %-32s %-16s\n%-32s %-32s %-16s\n",
            "Book Name", "Author", "Year Published",
            "---------", "------", "--------------");
    String MOVIE_DETAILS_HEADER = String.format("%-32s %-32s %-16s %16s\n%-32s %-32s %-16s %16s\n",
            "Movie Name", "Director", "Release Year", "Rating",
            "----------", "--------", "------------", "-------");
}
