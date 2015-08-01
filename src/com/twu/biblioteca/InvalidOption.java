package com.twu.biblioteca;

public class InvalidOption {

    private View view;

    public InvalidOption(View view) {
        this.view = view;
    }

    public void execute() {
        view.printMessage("Select a valid option!");
    }
}
