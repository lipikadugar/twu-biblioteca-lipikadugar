package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnTrueForTheCredentialsGiven() {
        User user = new User("123-4567", "!abcd1234");

        assertEquals(true, user.verify("123-4567", "!abcd1234"));

    }
}
