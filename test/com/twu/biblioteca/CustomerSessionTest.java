package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.CheckOut;
import com.twu.biblioteca.view.CustomerSession;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class CustomerSessionTest {

    Library bookSection;
    Library movieSection;
    View view;
    User user;

    @Before
    public void setUp() {
        bookSection = Mockito.mock(Library.class);
        view = Mockito.mock(View.class);
        user = Mockito.mock(User.class);
    }

    @Test
    public void shouldGiveObjectForCheckOutClassIfOptionIsCheckOut() {
        CheckOut checkout = new CheckOut("2", bookSection, movieSection, view, user);
        CustomerSession session = new CustomerSession(view, bookSection, movieSection, user);

        assertEquals(checkout.getClass(), session.getClassObject("2").getClass());
    }
}
