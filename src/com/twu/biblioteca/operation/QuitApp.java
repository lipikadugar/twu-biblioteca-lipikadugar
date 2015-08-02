package com.twu.biblioteca.operation;

public class QuitApp implements Operations {

    @Override
    public void execute() {
        System.exit(0);
    }
}
