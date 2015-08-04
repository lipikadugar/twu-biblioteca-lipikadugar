package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldReturnTrueForTheCredentialsGiven() {
        User user = new User("000-0000", "!abcd0123", "Lisa", "lisa@gmail.com", "7890678341");

        assertEquals(true, user.verify("000-0000", "!abcd0234"));
    }

    @Test
    public void shouldReturnFalseIfTheCredentialsDoesNotMatch() {
        User user = new User("000-0000", "!abcd0123", "Lisa", "lisa@gmail.com", "7890678341");

        assertEquals(false, user.verify("000-00000", "!abcd0234"));
    }
}
