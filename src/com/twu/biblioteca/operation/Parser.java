package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

import java.util.HashMap;
import java.util.Scanner;

public class Parser {

    private HashMap<String, Operations> input;
    Scanner in;

    public Parser(Library library, View view) {
        input = new HashMap<>();
        input.put("1", new View("1", library, in));
        input.put("2", new CheckOut("2", library, view));
        input.put("3", new CheckIn(library, view));
        input.put("4", new ListCheckedOutItem("4", library, view));
        input.put("5", new View("5", library, in));
        input.put("6", new CheckOut("6", library, view));
        input.put("7", new ListCheckedOutItem("7", library, view));
        input.put("8", new QuitApp());
    }

    public Operations getClassObject(String key) {
        return input.get(key);
    }
}





