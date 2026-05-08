package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {

    private final StringProcessor sp = new StringProcessor();

    @Test
    void testReverse() {
        assertEquals("olleh", sp.reverse("hello"));
    }

    @Test
    void testReverseEmpty() {
        assertEquals("", sp.reverse(""));
    }

    @Test
    void testReverseNull() {
        assertThrows(IllegalArgumentException.class, () -> sp.reverse(null));
    }

    @Test
    void testIsPalindromeTrue() {
        assertTrue(sp.isPalindrome("racecar"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(sp.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeWithSpaces() {
        assertTrue(sp.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testCountWords() {
        assertEquals(3, sp.countWords("hello world foo"));
    }

    @Test
    void testCountWordsEmpty() {
        assertEquals(0, sp.countWords(""));
    }

    @Test
    void testCountWordsNull() {
        assertEquals(0, sp.countWords(null));
    }

    @Test
    void testCapitalize() {
        assertEquals("Hello", sp.capitalize("hELLO"));
    }

    @Test
    void testCapitalizeEmpty() {
        assertEquals("", sp.capitalize(""));
    }
}
