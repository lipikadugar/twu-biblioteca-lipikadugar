package com.twu.biblioteca;

import com.twu.biblioteca.view.UserSession;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class UserSessionTest {

    @Test
    public void shouldDisplayMenuForUser() {
        View view = Mockito.mock(View.class);
        UserSession session = new UserSession(view);

        session.start();

        verify(view).print("=========================================\n\t\tMenu\n" +
                "\t1. List Book Details\n" +
                "\t2. Checkout Book\n" +
                "\t3. Return Book\n" +
                "\t5. List Movie Details\n" +
                "\t6. Checkout Movie\n" +
                "\t8. Return Movie\n" +
                "\t9. Quit\n" +
                "=========================================\n");
    }
}
