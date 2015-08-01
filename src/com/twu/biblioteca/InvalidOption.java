package com.twu.biblioteca;

public class InvalidOption implements Operations {

    private View view;

    public InvalidOption(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.printMessage("Select a valid option!");
    }
}
