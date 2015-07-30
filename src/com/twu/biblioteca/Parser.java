package com.twu.biblioteca;

import java.util.HashMap;

public class Parser {

    private HashMap<String, Operations> input;

    public Parser() {
        input = new HashMap<>();
        input.put("listBooks", new View());
        input.put("checkout", new Checkout());
        input.put("checkin", new CheckIn());
        input.put("quit", new QuitApp());
    }

    public Operations getClassObject(String key) {
        return input.get(key);
    }
}





