package com.extreme.startup;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

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
        Function<List<Integer>,Integer> largestOperation = l -> l.stream().mapToInt(n -> n).max().orElse(0);

        String result = calculator.calculate(numbers, largestOperation);

        assertThat(result, is("860"));
    }

    @Test
    public void returnMultipliedNumbers() {
        BiFunction<Integer,Integer,Integer> multiply = (a,b) -> a * b;

        String result = calculator.calculate(5, 8, multiply);

        assertThat(result, is("40"));
    }

    @Test
    public void returnSqrtAndCubeOfNumbers() {
        List<Integer> numbers = Arrays.asList(121, 249);
        Function<List<Integer>,Integer> sqrtOperation = l -> l.stream().filter(n -> Math.sqrt(n) % 1 == 0).findFirst().orElse(0);

        String result = calculator.calculate(numbers, sqrtOperation);

        assertThat(result, is("121"));
    }

    @Test
    public void returnListOfPrimeNumbers() {
        List<Integer> numbers = Arrays.asList(307, 420, 173, 347);

        String result = calculator.calculatePrimes(numbers);

        assertThat(result, is("307, 173, 347"));
    }
}
