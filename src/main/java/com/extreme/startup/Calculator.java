package com.extreme.startup;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    public String calculate(int oper1, int oper2, BiFunction<Integer, Integer, Integer> operation) {
        return String.valueOf(operation.apply(oper1, oper2));
    }

    public String calculate(List<Integer> numbers, Function<List<Integer>,Integer> function) {
        return String.valueOf(function.apply(numbers));
    }

    public String calculatePrimes(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isPrime)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private boolean isPrime(Integer number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }
}
