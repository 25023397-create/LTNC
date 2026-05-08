package com.lab;

public class ShippingCalculator {

    public double calculate(double weight, String type) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        if (type.equals("EXPRESS")) {
            return weight * 5000 + 20000;
        }
        if (type.equals("STANDARD")) {
            return weight * 3000;
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }

    public static void main(String[] args) {
        ShippingCalculator calc = new ShippingCalculator();
        System.out.println("STANDARD 5kg: " + calc.calculate(5, "STANDARD"));
        System.out.println("EXPRESS 5kg:  " + calc.calculate(5, "EXPRESS"));
    }
}
