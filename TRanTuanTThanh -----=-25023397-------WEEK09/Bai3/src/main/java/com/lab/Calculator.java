package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public double add(double a, double b) {
        double result = a + b;
        logger.info("add({}, {}) = {}", a, b, result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        logger.info("subtract({}, {}) = {}", a, b, result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        logger.info("multiply({}, {}) = {}", a, b, result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            logger.error("Division by zero: {} / {}", a, b);
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        logger.info("divide({}, {}) = {}", a, b, result);
        return result;
    }

    public static void main(String[] args) {
        logger.info("Calculator application started");
        Calculator calc = new Calculator();
        logger.info("Result: {}", calc.add(10, 5));
        logger.info("Result: {}", calc.divide(20, 4));
        logger.info("Calculator application finished");
    }
}
