package com.twu.biblioteca.operation;

import com.twu.biblioteca.view.BibliotecaApp;

public class Logout implements Operations {
    private BibliotecaApp bibliotecaApp;

    public Logout(BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
    }

    @Override
    public void execute() {
        bibliotecaApp.start(true);
    }
}
