package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.model.UserAuthentication;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserAuthenticationTest {
    ArrayList<User> users;

    @Before
    public void setup() {
        users = new ArrayList<>();
        User user1 = new User("123-4567", "!abcd1234", "Lisa", "lisa@gmail.com", "7890678341");
        users.add(user1);
        User user2 = new User("000-0000", "!abcd0123", "Lisa", "lisa@gmail.com", "7890678341");
        users.add(user2);
    }

    @Test
    public void shouldAuthenticateAUserWhenCredentialsAreMatched() {
        UserAuthentication user = new UserAuthentication(users);
        User user1 = user.authenticate("123-4567", "!abcd1234");

        assertEquals("UserID: 123-4567\n" +
                "Name: Lisa\n" +
                "Email: lisa@gmail.com\n" +
                "Phone: 7890678341", user1.toString());
    }

    @Test
    public void shouldReturnNullIfTheUserCredentialsAreNotMatched() {
        UserAuthentication user = new UserAuthentication(users);

        assertEquals(null, user.authenticate("123-4567", "!abcd"));
    }
}
