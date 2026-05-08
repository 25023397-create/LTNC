package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserValidator {

    private static final Logger logger = LoggerFactory.getLogger(UserValidator.class);

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            logger.warn("Email validation failed: null or empty input");
            return false;
        }
        boolean valid = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        logger.info("Email '{}' is valid: {}", email, valid);
        return valid;
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            logger.error("Password validation failed: null input");
            return false;
        }
        // Toi thieu 8 ky tu, co chu hoa, chu thuong, so
        boolean valid = password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*");
        logger.info("Password validation result: {}", valid);
        return valid;
    }

    public boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            logger.warn("Username validation failed: null or empty");
            return false;
        }
        boolean valid = username.matches("^[a-zA-Z0-9_]{3,20}$");
        logger.info("Username '{}' is valid: {}", username, valid);
        return valid;
    }

    public static void main(String[] args) {
        logger.info("=== UserValidator Demo ===");
        UserValidator validator = new UserValidator();
        logger.info("Email valid: {}", validator.isValidEmail("user@example.com"));
        logger.info("Password valid: {}", validator.isValidPassword("Pass1234"));
        logger.info("Username valid: {}", validator.isValidUsername("john_doe"));
        logger.info("=== Done ===");
    }
}
