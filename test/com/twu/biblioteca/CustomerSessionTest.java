package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.operation.Logout;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.CustomerSession;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CustomerSessionTest {

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        CheckOut checkout = new CheckOut("2", library, view, user);
        CustomerSession session = new CustomerSession(view, library, app, user);
        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }

    @Test
    public void shouldGiveObjectForLogoutClassIfOptionIsLogout() {
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        User user = Mockito.mock(User.class);
        CustomerSession session = new CustomerSession(view, library, app, user);
        Logout logout = new Logout(app);

        assertEquals(logout.getClass(), session.getClassObject("8").getClass());
    }
}
