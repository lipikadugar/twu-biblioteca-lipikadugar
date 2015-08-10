package com.twu.biblioteca.view;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class LoginMenuViewTest {
    @Test
    public void shouldDisplayLoginView() {
        View view = Mockito.mock(View.class);
        Dispatcher dispatch = Mockito.mock(Dispatcher.class);
        LoginMenuView login = new LoginMenuView(view, dispatch);

        login.execute();

        verify(view).print("=========================================\n" +
                "\t1. List Books\n" +
                "\t2. List Movies\n" +
                "\t3. Login as Librarian\n" +
                "\t4. Login as User\n" +
                "\t5. Quit\n" +
                "=========================================\n" +
                "Choose a option: \n");
    }
}
