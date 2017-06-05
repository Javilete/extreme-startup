package com.extreme.startup;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {

    public String calculate(int oper1, int oper2, BiFunction<Integer, Integer, Integer> operation) {
        return String.valueOf(operation.apply(oper1, oper2));
    }

    public String calculate(List<Integer> numbers, Function<List<Integer>,Integer> function) {
        return String.valueOf(function.apply(numbers));
    }
}
