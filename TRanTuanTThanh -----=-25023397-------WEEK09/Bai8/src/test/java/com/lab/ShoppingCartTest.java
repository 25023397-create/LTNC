package com.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddAndGetTotal() {
        cart.addItem("Apple", 15000);
        cart.addItem("Banana", 10000);
        assertEquals(25000.0, cart.getTotal());
    }

    @Test
    void testDiscount() {
        cart.addItem("Item", 100000);
        assertEquals(90000.0, cart.getTotalWithDiscount(10), 0.001);
    }

    @Test
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Bad", -100));
    }

    @Test
    void testInvalidDiscount() {
        assertThrows(IllegalArgumentException.class, () -> cart.getTotalWithDiscount(150));
    }

    @Test
    void testItemCount() {
        cart.addItem("A", 1000);
        cart.addItem("B", 2000);
        assertEquals(2, cart.getItemCount());
    }
}
