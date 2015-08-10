package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.View;
import com.twu.biblioteca.view.WelcomeView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    Scanner in;
    Library bookSection;
    Library movieSection;
    UserAuthentication librarian;
    UserAuthentication user;
    WelcomeView welcome;

    @Before
    public void setUp() {
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        librarian = Mockito.mock(UserAuthentication.class);
        user = Mockito.mock(UserAuthentication.class);
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        View view = new View("1", bookSection, movieSection, in);
        BibliotecaApp app = new BibliotecaApp(view, in, bookSection, movieSection, librarian, user, welcome);

        assertEquals(view.getClass(), app.getClassObject("1").getClass());
    }
}
