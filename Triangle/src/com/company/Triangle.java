package com.company;

public class Triangle {
    public boolean triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Sides must have values above zero");
        }
        return a + b > c && a + c > b && b + c > a;
    }
}