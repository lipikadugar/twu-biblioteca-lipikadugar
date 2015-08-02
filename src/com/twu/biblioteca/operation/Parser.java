package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.operation.QuitApp;
import com.twu.biblioteca.view.View;

import java.util.HashMap;
import java.util.Scanner;

public class Parser {

    private HashMap<String, Operations> input;
    Scanner in;

    public Parser(Library library, View view) {
        input = new HashMap<>();
        input.put("1", new View(library, in));
        input.put("2", new CheckOut(library, view));
        input.put("3", new CheckIn(library, view));
        input.put("4", new QuitApp());
    }

    public Operations getClassObject(String key) {
        return input.get(key);
    }
}





