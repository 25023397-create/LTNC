package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    void testValidEmail() {
        assertTrue(validator.isValidEmail("user@example.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(validator.isValidEmail("not-an-email"));
    }

    @Test
    void testNullEmail() {
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValidPassword("SecurePass1"));
    }

    @Test
    void testWeakPassword() {
        assertFalse(validator.isValidPassword("weak"));
    }

    @Test
    void testValidUsername() {
        assertTrue(validator.isValidUsername("john_doe"));
    }

    @Test
    void testShortUsername() {
        assertFalse(validator.isValidUsername("ab"));
    }
}
