package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    // Dung static final Logger - khai bao theo chuan SLF4J
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public String createOrder(String customerId, String product, int quantity) {
        // INFO: ghi lai cac moc quan trong cua luong nghiep vu
        logger.info("Creating order: customerId={}, product={}, quantity={}",
                customerId, product, quantity);

        if (customerId == null || customerId.isEmpty()) {
            // ERROR: xu ly ngoai le - dung parameterized logging, khong dung cong chuoi
            logger.error("Order creation failed: customerId is null or empty");
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }

        if (quantity <= 0) {
            logger.error("Order creation failed: invalid quantity={} for customerId={}",
                    quantity, customerId);
            throw new IllegalArgumentException("Quantity must be positive");
        }

        String orderId = "ORD-" + System.currentTimeMillis();

        // INFO: Milestone quan trong - don hang da tao thanh cong
        logger.info("Order created successfully: orderId={}, customerId={}, product={}, quantity={}",
                orderId, customerId, product, quantity);

        return orderId;
    }

    public void processPayment(String orderId, double amount) {
        // INFO: bat dau xu ly thanh toan
        logger.info("Processing payment: orderId={}, amount={}", orderId, amount);

        if (amount <= 0) {
            logger.error("Payment failed: invalid amount={} for orderId={}", amount, orderId);
            throw new IllegalArgumentException("Payment amount must be positive");
        }

        // Gia lap xu ly thanh toan
        logger.info("Payment processed successfully: orderId={}, amount={}", orderId, amount);
    }

    public void cancelOrder(String orderId, String reason) {
        // WARN: huy don hang la su kien can chu y nhung khong phai loi nghiem trong
        logger.warn("Order cancelled: orderId={}, reason={}", orderId, reason);
    }

    public static void main(String[] args) {
        // INFO: ung dung bat dau
        logger.info("=== OrderService application started ===");

        OrderService service = new OrderService();

        try {
            String orderId = service.createOrder("CUST-001", "Laptop", 1);
            service.processPayment(orderId, 15000000);
            logger.info("Workflow completed successfully for orderId={}", orderId);
        } catch (Exception e) {
            // ERROR: bat loi voi thong tin day du, khong dung e.printStackTrace()
            logger.error("Unexpected error during order workflow: {}", e.getMessage(), e);
        }

        logger.info("=== OrderService application finished ===");
    }
}
