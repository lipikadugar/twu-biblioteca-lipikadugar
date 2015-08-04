package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.operation.UserInformation;
import com.twu.biblioteca.view.View;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInformationTest {

    @Test
    public void shouldDisplayUserInformation() {
        User user = Mockito.mock(User.class);
        View view = Mockito.mock(View.class);
        UserInformation information = new UserInformation(user, view);
        when(user.toString()).thenReturn("UserID: 123-4567\n" +
                "Name: Lisa\n" +
                "Email: lisa@gmail.com\n" +
                "Phone: 7890678341");

        information.execute();

        verify(view).print("UserID: 123-4567\n" +
                "Name: Lisa\n" +
                "Email: lisa@gmail.com\n" +
                "Phone: 7890678341");
    }
}
