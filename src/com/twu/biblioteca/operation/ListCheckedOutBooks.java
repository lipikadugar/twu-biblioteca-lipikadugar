package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class ListCheckedOutBooks implements Operations{
    private Library library;
    private View view;

    public ListCheckedOutBooks(Library library, View view) {

        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        String book = library.checkedOutList();
        view.print(book);
    }
}
