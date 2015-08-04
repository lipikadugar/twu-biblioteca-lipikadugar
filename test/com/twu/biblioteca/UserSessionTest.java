package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.Logout;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.LibrarianSession;
import com.twu.biblioteca.view.UserSession;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class UserSessionTest {

    @Test
    public void shouldDisplayMenuForUser() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        UserSession session = new UserSession(view, library);

        session.start(false);

        verify(view).print("=========================================\n\t\tMenu\n" +
                "\t1. List Book Details\n" +
                "\t2. Checkout Book\n" +
                "\t3. Return Book\n" +
                "\t4. List Movie Details\n" +
                "\t5. Checkout Movie\n" +
                "\t6. Return Movie\n" +
                "\t7. Logout\n" +
                "=========================================\n");
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkout = new CheckOut("2", library, view);

        UserSession session = new UserSession(view, library);
        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForLogoutClassIfOptionIsLogout() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        UserSession session = new UserSession(view, library);
        Logout logout = new Logout(app);

        assertEquals(logout.getClass(), session.getClassObject("7").getClass());
    }
}
