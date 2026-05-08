package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    private final List<Double> items = new ArrayList<>();

    public void addItem(String name, double price) {
        if (price < 0) {
            logger.error("Cannot add item '{}' with negative price: {}", name, price);
            throw new IllegalArgumentException("Price cannot be negative");
        }
        items.add(price);
        logger.info("Added item: '{}' at price {}", name, price);
    }

    public double getTotal() {
        double total = items.stream().mapToDouble(Double::doubleValue).sum();
        logger.info("Cart total: {}", total);
        return total;
    }

    public double getTotalWithDiscount(double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            logger.error("Invalid discount: {}%", discountPercent);
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        double total = getTotal();
        double discounted = total * (1 - discountPercent / 100);
        logger.info("Total after {}% discount: {}", discountPercent, discounted);
        return discounted;
    }

    public int getItemCount() {
        return items.size();
    }

    public static void main(String[] args) {
        logger.info("=== ShoppingCart Demo ===");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 15000);
        cart.addItem("Banana", 10000);
        cart.addItem("Orange", 20000);
        logger.info("Items: {}", cart.getItemCount());
        logger.info("Total: {}", cart.getTotal());
        logger.info("Total with 10% discount: {}", cart.getTotalWithDiscount(10));
        logger.info("=== Done ===");
    }
}
