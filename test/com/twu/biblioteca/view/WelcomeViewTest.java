package com.twu.biblioteca.view;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class WelcomeViewTest {

    @Test
    public void shouldDisplayWelcomeMessage() {
        View view = Mockito.mock(View.class);
        LoginMenuView loginMenuView = Mockito.mock(LoginMenuView.class);
        WelcomeView welcome = new WelcomeView(view, loginMenuView);

        welcome.execute();

        verify(view).print("\t!!..Welcome to the Bibliotica..!!");
    }
}
