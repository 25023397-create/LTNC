package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private final TemperatureConverter tc = new TemperatureConverter();

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(212.0, tc.celsiusToFahrenheit(100), 0.001);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, tc.fahrenheitToCelsius(32), 0.001);
    }

    @Test
    void testCelsiusToKelvin() {
        assertEquals(273.15, tc.celsiusToKelvin(0), 0.001);
    }
}
