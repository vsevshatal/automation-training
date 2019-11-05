package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle triangle = new Triangle();
    @Test
    void negativeSide() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangle(1,2,-3));
    }
    @Test
    void allNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangle(-1,-2,-2));
    }
    @Test
    void zeroSide() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangle(1,2,0));
    }
    @Test
    void allZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> triangle.triangle(0,0,0));
    }
    @Test
    void nonExistent() {
        assertFalse(triangle.triangle(1,2,4));
    }
    @Test
    void isoscelesTriangle() {
        assertTrue(triangle.triangle(1,2,2));
    }
    @Test
    void rightTriangle() {
        assertTrue(triangle.triangle(3,4,5));
    }
    @Test
    void equilateralTriangle() {
        assertTrue(triangle.triangle(3,3,3));
    }
    @Test
    void sumOfTwoSidesEqualsThird() {
        assertFalse(triangle.triangle(1,2,3));
    }
    @Test
    void existing() {
        assertTrue(triangle.triangle(2,4,5));
    }

}