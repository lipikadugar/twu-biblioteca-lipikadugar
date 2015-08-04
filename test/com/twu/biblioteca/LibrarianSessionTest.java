package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.operation.Logout;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LibrarianSessionTest {

    Scanner in;

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("2", library, view);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);
        View view = new View("1", library, in);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        assertEquals(view.getClass(), session.getClassObject("1").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("3", library, view);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        assertEquals(checkIn.getClass(), session.getClassObject("3").getClass());
    }

    @Test
    public void shouldGiveObjectForQuitClassIfOptionIsQuit() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        Logout logout = new Logout(app);

        assertEquals(logout.getClass(), session.getClassObject("9").getClass());
    }

    @Test
    public void shouldGiveObjectForListBookClassIfOptionIsListCheckedOutBooks() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        ListCheckedOutItem list = new ListCheckedOutItem("4", library, view);

        assertEquals(list.getClass(), session.getClassObject("4").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListMovieDetails() {
        Library library = Mockito.mock(Library.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        View view = new View("5", library, in);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);

        assertEquals(view.getClass(), session.getClassObject("5").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOutMovies() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("6", library, view);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);

        assertEquals(checkout.getClass(), session.getClassObject("6").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckedOutItemClassIfOptionIsListCheckedOutMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);
        ListCheckedOutItem list = new ListCheckedOutItem("7", library, view);

        assertEquals(list.getClass(), session.getClassObject("7").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckInMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("8", library, view);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        LibrarianSession session = new LibrarianSession(view, library, app, user);

        assertEquals(checkIn.getClass(), session.getClassObject("8").getClass());
    }
}
