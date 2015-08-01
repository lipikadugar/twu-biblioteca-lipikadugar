package com.twu.biblioteca;

import java.util.HashMap;

public class Parser {

    private HashMap<String, Operations> input;

    public Parser(Library library, View view) {
        input = new HashMap<>();
        input.put("1", new View(library));
        input.put("2", new CheckOut(library, view));
    }

    public Operations getClassObject(String key) {
        return input.get(key);
    }
}





