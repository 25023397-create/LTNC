package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringProcessor {

    private static final Logger logger = LoggerFactory.getLogger(StringProcessor.class);

    public String reverse(String input) {
        if (input == null) {
            logger.error("reverse() called with null input");
            throw new IllegalArgumentException("Input cannot be null");
        }
        String result = new StringBuilder(input).reverse().toString();
        logger.info("reverse('{}') = '{}'", input, result);
        return result;
    }

    public boolean isPalindrome(String input) {
        if (input == null) {
            logger.error("isPalindrome() called with null input");
            throw new IllegalArgumentException("Input cannot be null");
        }
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        boolean result = cleaned.equals(new StringBuilder(cleaned).reverse().toString());
        logger.info("isPalindrome('{}') = {}", input, result);
        return result;
    }

    public int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            logger.warn("countWords() called with empty/null input");
            return 0;
        }
        int count = sentence.trim().split("\\s+").length;
        logger.info("countWords('{}') = {}", sentence, count);
        return count;
    }

    public String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            logger.warn("capitalize() called with empty/null input");
            return input;
        }
        String result = Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
        logger.info("capitalize('{}') = '{}'", input, result);
        return result;
    }

    public static void main(String[] args) {
        logger.info("=== StringProcessor Demo ===");
        StringProcessor sp = new StringProcessor();
        logger.info("reverse: {}", sp.reverse("hello"));
        logger.info("isPalindrome: {}", sp.isPalindrome("racecar"));
        logger.info("countWords: {}", sp.countWords("hello world foo"));
        logger.info("capitalize: {}", sp.capitalize("hELLO"));
        logger.info("=== Done ===");
    }
}
