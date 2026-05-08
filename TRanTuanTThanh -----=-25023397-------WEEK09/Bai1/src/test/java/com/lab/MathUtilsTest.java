package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    private final MathUtils math = new MathUtils();

    @Test
    void testAdd() {
        assertEquals(8, math.add(3, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(6, math.subtract(10, 4));
    }

    @Test
    void testMultiply() {
        assertEquals(42, math.multiply(6, 7));
    }

    @Test
    void testDivide() {
        assertEquals(5.0, math.divide(15, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> math.divide(10, 0));
    }
}
