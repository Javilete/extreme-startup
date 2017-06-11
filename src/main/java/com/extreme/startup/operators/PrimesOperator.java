package com.extreme.startup.operators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimesOperator extends Operator{

    private static PrimesOperator INSTANCE = null;

    private PrimesOperator() {

    }

    public static PrimesOperator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PrimesOperator();
        }

        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        List<Integer> numbers = extractValues(matcher);
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
