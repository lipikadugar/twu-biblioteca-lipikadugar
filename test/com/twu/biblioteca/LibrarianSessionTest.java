package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.operation.UserInformation;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LibrarianSessionTest {

    Scanner in;
    Library bookSection;
    Library movieSection;
    View view;
    User user;
    BibliotecaApp app;

    @Before
    public void setUp() {
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        user = Mockito.mock(User.class);
        app = Mockito.mock(BibliotecaApp.class);
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("2", bookSection, movieSection, view, user);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);

        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        View view = new View("1", bookSection, movieSection, in);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);
        assertEquals(view.getClass(), session.getClassObject("1").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("3", bookSection, bookSection, view, user);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);
        assertEquals(checkIn.getClass(), session.getClassObject("3").getClass());
    }

    @Test
    public void shouldGiveObjectForListBookClassIfOptionIsListCheckedOutBooks() {
        View view = Mockito.mock(View.class);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);
        ListCheckedOutItem list = new ListCheckedOutItem("4", bookSection, movieSection, view);

        assertEquals(list.getClass(), session.getClassObject("4").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListMovieDetails() {
        View view = new View("5", bookSection, movieSection, in);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);

        assertEquals(view.getClass(), session.getClassObject("5").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOutMovies() {
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("6", bookSection, movieSection, view, user);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);

        assertEquals(checkout.getClass(), session.getClassObject("6").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckedOutItemClassIfOptionIsListCheckedOutMovie() {
        View view = Mockito.mock(View.class);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);
        ListCheckedOutItem list = new ListCheckedOutItem("7", bookSection, movieSection, view);

        assertEquals(list.getClass(), session.getClassObject("7").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckInMovie() {
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("8", bookSection, bookSection, view, user);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);

        assertEquals(checkIn.getClass(), session.getClassObject("8").getClass());
    }

    @Test
    public void shouldGiveObjectForUserInformationClassIfOptionIsMyProfile() {
        View view = Mockito.mock(View.class);
        UserInformation userInfo = new UserInformation(user, view);
        LibrarianSession session = new LibrarianSession(view, bookSection, movieSection, user);

        assertEquals(userInfo.getClass(), session.getClassObject("9").getClass());
    }
}
