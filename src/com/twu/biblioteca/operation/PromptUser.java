package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.Operations;
import com.twu.biblioteca.view.View;

public class PromptUser implements Operations {
    private final View view;
    private final UserAuthentication librarian;
    private final Library library;

    public PromptUser(View view, UserAuthentication librarian, Library library) {
        this.view = view;
        this.librarian = librarian;
        this.library = library;
    }

    @Override
    public void execute() {

    }
}
