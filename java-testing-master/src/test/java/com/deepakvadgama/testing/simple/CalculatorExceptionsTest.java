package com.deepakvadgama.testing.simple;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorExceptionsTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidNumberAddition() {
        calculator.add("invalid-number", "2");
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInvalidNumberAddition2() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("For input string: \"invalid-number\"");

        calculator.add("invalid-number", "2");
    }

}