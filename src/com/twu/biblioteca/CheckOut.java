package com.twu.biblioteca;

public class CheckOut implements Operations {
    private Library library;

    public CheckOut(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        System.out.println("Thank you for returning the book.");
    }
}
