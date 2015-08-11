package com.twu.biblioteca.operation;

import com.twu.biblioteca.Initiator.BibliotecaApp;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserAuthentication;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PromptUserTest {

    View view;
    UserAuthentication user;
    UserAuthentication librarian;
    Library bookSection;
    Library movieSection;
    BibliotecaApp app;
    User users;

    @Before
    public void setUp() {
        view = Mockito.mock(View.class);
        user = Mockito.mock(UserAuthentication.class);
        librarian = Mockito.mock(UserAuthentication.class);
        bookSection = Mockito.mock(Library.class);
        movieSection = Mockito.mock(Library.class);
        users = Mockito.mock(User.class);
        app = Mockito.mock(BibliotecaApp.class);
    }

    @Test
    public void shouldBeAblePromptTheUserToLogin() {
        PromptUser promptUser = new PromptUser("3", view, librarian, bookSection, movieSection);

        promptUser.execute();

        verify(view).print("Enter user ID : ");
        verify(view).print("Enter Password: ");
        verify(view, times(2)).input();
    }

    @Test
    public void shouldBeAbleToDisplayInvalidUserMessageIfUserIsFailedToAuthenticated() {
        PromptUser promptUser = new PromptUser("3", view, user, bookSection, movieSection);
        when(user.authenticate("999-1234", "password")).thenReturn(users);

        promptUser.execute();

        verify(view).print("Enter user ID : ");
        verify(view).print("Enter Password: ");
        verify(view, times(2)).input();
        verify(view).print("The userID and password does not match. Try again.");
    }
}
