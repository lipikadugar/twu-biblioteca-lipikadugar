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
        User user1 = new User("123-4567", "!abcd1234");
        users.add(user1);
        User user2 = new User("xyz-abcd", "abcd");
        users.add(user2);
    }

    @Test
    public void shouldAuthenticateAUserWhenCredentialsAreMatched() {
        UserAuthentication user = new UserAuthentication(users);
        User newUser = new User("123-4567", "!abcd1234");

        assertEquals(true, user.authenticate(newUser));
    }

    @Test
    public void shouldReturnFalseIfTheUserCredentialsAreNotMatched() {
        UserAuthentication user = new UserAuthentication(users);
        User newUser = new User("123-4567", "!abcd");

        assertEquals(false, user.authenticate(newUser));
    }
}
