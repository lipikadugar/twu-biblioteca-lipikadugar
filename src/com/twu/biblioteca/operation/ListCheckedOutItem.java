package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

public class ListCheckedOutItem implements Operations{
    private String option;
    private Library library;
    private View view;

    public ListCheckedOutItem(String option, Library library, View view) {
        this.option = option;
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        String book = library.checkedOutList();
        view.print(book);
    }
}
