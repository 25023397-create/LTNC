package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    void testCreateOrderSuccess() {
        String orderId = service.createOrder("CUST-001", "Laptop", 1);
        assertNotNull(orderId);
        assertTrue(orderId.startsWith("ORD-"));
    }

    @Test
    void testCreateOrderEmptyCustomer() {
        assertThrows(IllegalArgumentException.class,
                () -> service.createOrder("", "Laptop", 1));
    }

    @Test
    void testCreateOrderInvalidQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> service.createOrder("CUST-001", "Laptop", 0));
    }

    @Test
    void testProcessPayment() {
        assertDoesNotThrow(() -> service.processPayment("ORD-123", 100000));
    }

    @Test
    void testProcessPaymentInvalidAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> service.processPayment("ORD-123", -500));
    }
}
