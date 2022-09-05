package com.example.b2synchronous;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    Calculator mCalculator;

    public void setUp() throws Exception {
        super.setUp();
        mCalculator = new Calculator();
    }

    public void tearDown() throws Exception {
    }

    public void testAdd() {
        int expected = 45;
        int actual = mCalculator.add(10,20);
        assertEquals(expected,actual);
    }

    public void testMult(){
        int expected = 20;
        int actual = mCalculator.multiply(5,4);
        assertEquals(expected,actual);
    }
}