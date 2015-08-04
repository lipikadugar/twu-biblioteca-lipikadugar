package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.operation.PromptUser;
import com.twu.biblioteca.view.BibliotecaApp;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PromptUserTest {

    @Test
    public void shouldBeAblePromptTheUserToLogin() {
        View view = Mockito.mock(View.class);
        UserAuthentication librarian = Mockito.mock(UserAuthentication.class);
        Library library = Mockito.mock(Library.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        PromptUser promptUser = new PromptUser("3", view, librarian, library, app);

        promptUser.execute();

        verify(view).print("Enter user ID : ");
        verify(view).print("Enter Password: ");
        verify(view, times(2)).input();
    }

    @Test
    public void shouldBeAbleToDisplayInvalidUserMessageIfUserIsFailedToAuthenticated() {
        View view = Mockito.mock(View.class);
        UserAuthentication user = Mockito.mock(UserAuthentication.class);
        Library library = Mockito.mock(Library.class);
        BibliotecaApp app = Mockito.mock(BibliotecaApp.class);
        PromptUser promptUser = new PromptUser("3", view, user, library, app);
        when(user.authenticate("999-1234", "password")).thenReturn(false);

        promptUser.execute();

        verify(view).print("Enter user ID : ");
        verify(view).print("Enter Password: ");
        verify(view, times(2)).input();
        verify(view).print("The userID and password does not match. Try again.");
    }
}
