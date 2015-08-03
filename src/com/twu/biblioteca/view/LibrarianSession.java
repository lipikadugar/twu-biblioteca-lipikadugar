package com.twu.biblioteca.view;

import static com.twu.biblioteca.view.Messages.MENU_FOR_LIBRARIAN;

public class LibrarianSession {
    private View view;

    public LibrarianSession(View view) {

        this.view = view;
    }

    public void start() {
        view.print(MENU_FOR_LIBRARIAN);
    }
}
