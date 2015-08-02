package com.twu.biblioteca.operation;

import com.twu.biblioteca.operation.Operations;

public class QuitApp implements Operations {

    @Override
    public void execute() {
        System.exit(0);
    }
}
