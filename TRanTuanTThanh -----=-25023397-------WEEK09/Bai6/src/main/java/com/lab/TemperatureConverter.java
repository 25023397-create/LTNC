package com.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemperatureConverter {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureConverter.class);

    public double celsiusToFahrenheit(double celsius) {
        double result = (celsius * 9.0 / 5.0) + 32;
        logger.info("{}°C = {}°F", celsius, result);
        return result;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        double result = (fahrenheit - 32) * 5.0 / 9.0;
        logger.info("{}°F = {}°C", fahrenheit, result);
        return result;
    }

    public double celsiusToKelvin(double celsius) {
        double result = celsius + 273.15;
        logger.info("{}°C = {}K", celsius, result);
        return result;
    }

    public static void main(String[] args) {
        logger.info("=== TemperatureConverter Demo ===");
        TemperatureConverter tc = new TemperatureConverter();
        logger.info("100C to F: {}", tc.celsiusToFahrenheit(100));
        logger.info("32F to C: {}", tc.fahrenheitToCelsius(32));
        logger.info("0C to K: {}", tc.celsiusToKelvin(0));
        logger.info("=== Done ===");
    }
}
