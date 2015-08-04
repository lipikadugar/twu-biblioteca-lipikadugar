package com.twu.biblioteca.operation;

import com.twu.biblioteca.view.BibliotecaApp;

public class Logout implements Operations {
    private BibliotecaApp app;

    public Logout(BibliotecaApp app) {
        this.app = app;

    }
    @Override
    public void execute() {
        app.start(true);
    }
}
