package com.twu.biblioteca;

import com.twu.biblioteca.operation.Logout;
import com.twu.biblioteca.view.BibliotecaApp;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LogoutTest {

    @Test
    public void shouldDisplayTheLoginScreen() {
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        Logout logout = new Logout(app);

        logout.execute();

        verify(app, times(1)).start(true);
    }
}
