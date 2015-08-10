package com.twu.biblioteca.Initiator;

import com.twu.biblioteca.view.WelcomeView;

public class BibliotecaApp {
    private WelcomeView welcome;


    public BibliotecaApp(WelcomeView welcome) {
        this.welcome = welcome;
    }

    public void start(boolean executeMenu) {
        while (executeMenu) {
            welcome.execute();
        }
    }
}
