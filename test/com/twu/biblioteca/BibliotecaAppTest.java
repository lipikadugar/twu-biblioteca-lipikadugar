package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    Scanner in;
    Library bookSection;
    Library movieSection;
    View view;
    UserAuthentication librarian;
    UserAuthentication user;
    BibliotecaApp app;

    @Before
    public void setUp() {
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        librarian = Mockito.mock(UserAuthentication.class);
        user = Mockito.mock(UserAuthentication.class);

    }

    @Test
    public void shouldDisplayWelcomeMessageAndLoginMenu() {
        view = Mockito.mock(View.class);
        app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, user);
        app.start(false);

        verify(view).print("\t!!..Welcome to the Bibliotica..!!");
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        View view = new View("1", bookSection, movieSection, in);
        BibliotecaApp app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, user);

        assertEquals(view.getClass(), app.getClassObject("1").getClass());
    }
}
