package com.twu.biblioteca;

import java.util.ArrayList;

public class View {
    ArrayList<String[][]> bookList;

    public void display(BookList list) {

        bookList = (ArrayList<String [][]>) list.getDetails();
        for (String[][] details : bookList) {
            System.out.println(details[0][0]);
            System.out.println(details[1][0]);
            System.out.println(details[2][0]);
        }
    }

    public void displayDetails(BookList list) {
        bookList = (ArrayList<String [][]>) list.getDetails();
        for (String[][] details : bookList) {
            for (int j = 0; j < details[0].length; j++)
                System.out.println(details[j][0] + " \t " + details[j][1] + " \t " + details[j][2]);
        }
    }
}

