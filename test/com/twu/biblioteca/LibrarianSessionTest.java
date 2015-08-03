package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.CheckIn;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.ListCheckedOutItem;
import com.twu.biblioteca.operation.QuitApp;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class LibrarianSessionTest {

    Scanner in;

    @Test
    public void shouldDisplayTheMenuForLibrarian() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);

        LibrarianSession session = new LibrarianSession(view, library);

        session.start(false);

        verify(view).print("=========================================\n" +
                        "\t\tMenu\n" +
                        "\t1. List Book Details\n" +
                        "\t2. Checkout\n" +
                        "\t3. Return Book\n" +
                        "\t4. List Checked Out Books\n" +
                        "\t5. List Movie Details\n" +
                        "\t6. Checkout Movie\n" +
                        "\t7. List Checked Out Movies\n" +
                        "\t8. Return Movie\n" +
                        "\t9. Quit\n" +
                        "=========================================\n" +
                        "Choose a option: "
        );
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("2", library, view);

        LibrarianSession session = new LibrarianSession(view, library);
        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListBooks() {
        Library library = Mockito.mock(Library.class);
        View view = new View("1", library, in);

        LibrarianSession session = new LibrarianSession(view, library);
        assertEquals(view.getClass(), session.getClassObject("1").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckIn() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("3", library, view);

        LibrarianSession session = new LibrarianSession(view, library);
        assertEquals(checkIn.getClass(), session.getClassObject("3").getClass());
    }

    @Test
    public void shouldGiveObjectForQuitClassIfOptionIsQuit() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        LibrarianSession session = new LibrarianSession(view, library);
        QuitApp quit = new QuitApp();

        assertEquals(quit.getClass(), session.getClassObject("9").getClass());
    }

    @Test
    public void shouldGiveObjectForListBookClassIfOptionIsListCheckedOutBooks() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        LibrarianSession session = new LibrarianSession(view, library);
        ListCheckedOutItem list = new ListCheckedOutItem("4", library, view);

        assertEquals(list.getClass(), session.getClassObject("4").getClass());
    }

    @Test
    public void shouldGiveObjectForViewClassIfOptionIsListMovieDetails() {
        Library library = Mockito.mock(Library.class);
        View view = new View("5", library, in);
        LibrarianSession session = new LibrarianSession(view, library);

        assertEquals(view.getClass(), session.getClassObject("5").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOutMovies() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("6", library, view);
        LibrarianSession session = new LibrarianSession(view, library);

        assertEquals(checkout.getClass(), session.getClassObject("6").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckedOutItemClassIfOptionIsListCheckedOutMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        LibrarianSession session = new LibrarianSession(view, library);
        ListCheckedOutItem list = new ListCheckedOutItem("7", library, view);

        assertEquals(list.getClass(), session.getClassObject("7").getClass());
    }

    @Test
    public void shouldGiveObjectForCheckInClassIfOptionIsCheckInMovie() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn("8", library, view);
        LibrarianSession session = new LibrarianSession(view, library);

        assertEquals(checkIn.getClass(), session.getClassObject("8").getClass());
    }
}
