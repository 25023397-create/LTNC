package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {

    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        logger.info("Adding {} + {}", a, b);
        return a + b;
    }

    public int subtract(int a, int b) {
        logger.info("Subtracting {} - {}", a, b);
        return a - b;
    }

    public int multiply(int a, int b) {
        logger.info("Multiplying {} * {}", a, b);
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero attempted: {} / {}", a, b);
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        logger.info("Dividing {} / {}", a, b);
        return (double) a / b;
    }

    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        logger.info("=== MathUtils Demo ===");
        logger.info("add(3, 5) = {}", math.add(3, 5));
        logger.info("subtract(10, 4) = {}", math.subtract(10, 4));
        logger.info("multiply(6, 7) = {}", math.multiply(6, 7));
        logger.info("divide(15, 3) = {}", math.divide(15, 3));
        logger.info("=== Done ===");
    }
}
