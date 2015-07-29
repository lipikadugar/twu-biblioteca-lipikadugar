package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class View {

    public void welcomeMessage() {
        System.out.print("\t!!..Welcome to the Bibliotica..!!\n");
    }

    public void displayMenu() {
        System.out.println("=========================================");
        System.out.println("\t\tMenu");
        System.out.println("\t1. List Book Details");
        System.out.println("\t2. Quit");
        System.out.println("=========================================");
        System.out.println("Choose a option: ");

    }

    public void displayDetails(ArrayList<HashMap> books) {
        for (int index = 0; index < books.size(); index++)
        {
            HashMap book = books.get(index);
            String bookName = (String) book.get("bookName");
            String author = (String) book.get("author");
            Integer yearPublished = (Integer) book.get("yearPublished");
            System.out.println(bookName + " | " + author + " | " + yearPublished);
        }
    }
}

