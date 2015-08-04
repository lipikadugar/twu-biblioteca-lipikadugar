package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    Scanner in;

    @Test
    public void shouldDisplayWelcomeMessageAndLoginMenu() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);

        BibliotecaApp app = new BibliotecaApp(view, in, library);

        app.start(false);

        verify(view).print("!!..Welcome to the Bibliotica..!!");
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);
        View view = new View("1", library, in);
        BibliotecaApp app = new BibliotecaApp(view, in, library);

        assertEquals(view.getClass(), app.getClassObject("1").getClass());
    }
}
