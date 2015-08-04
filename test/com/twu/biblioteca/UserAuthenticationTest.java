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

        assertEquals(true, user.authenticate("123-4567", "!abcd1234"));
    }

    @Test
    public void shouldReturnFalseIfTheUserCredentialsAreNotMatched() {
        UserAuthentication user = new UserAuthentication(users);

        assertEquals(false, user.authenticate("123-4567", "!abcd"));
    }
}
