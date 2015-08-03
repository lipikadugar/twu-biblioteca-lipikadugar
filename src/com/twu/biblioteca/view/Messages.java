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
            "\t9. Quit\n" +
            "=========================================\n" +
            "Choose a option: ";
    String MENU_FOR_USER = "=========================================\n\t\tMenu\n" +
            "\t1. List Book Details\n" +
            "\t2. Checkout Book\n" +
            "\t3. Return Book\n" +
            "\t4. List Movie Details\n" +
            "\t5. Checkout Movie\n" +
            "\t6. Return Movie\n" +
            "\t7. Quit\n" +
            "=========================================\n";
    String ERROR_MESSAGE = "Select a valid option!";
    String WELCOME_MESSAGE = "!!..Welcome to the Bibliotica..!!";
}
