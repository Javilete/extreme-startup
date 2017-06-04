package com.extreme.startup;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiFunction;

public class Calculator {

    public String calculate(int oper1, int oper2, BiFunction<Integer, Integer, Integer> operation) {
        return String.valueOf(operation.apply(oper1, oper2));
    }

    public String calculate(List<Integer> list) {
        OptionalInt maxOpt = list.stream()
                .mapToInt(number -> number)
                .max();

        return String.valueOf(maxOpt.orElse(0));
    }
}
