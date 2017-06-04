package com.extreme.startup;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorShould {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void returnSumOperation() {
        BiFunction<Integer,Integer,Integer> sum = (a,b) -> a + b;

        String result = calculator.calculate(3, 16, sum);

        assertThat(result, is("19"));
    }

    @Test
    public void returnTheLargestInAList() {
        List<Integer> numbers = Arrays.asList(15, 3, 135, 860);

        String result = calculator.calculate(numbers);

        assertThat(result, is("860"));
    }

    @Test
    public void returnMultipliedNumbers() {
        BiFunction<Integer,Integer,Integer> multiply = (a,b) -> a * b;

        String result = calculator.calculate(5, 8, multiply);

        assertThat(result, is("40"));
    }
}
