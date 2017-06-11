package com.extreme.startup.operators;

import java.util.List;
import java.util.regex.Matcher;

public class SqrtCubeOperator extends Operator {

    private static SqrtCubeOperator INSTANCE = null;

    private SqrtCubeOperator() {

    }

    public static SqrtCubeOperator getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SqrtCubeOperator();
        }

        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        List<Integer> numbers = extractValues(matcher);
        int result = numbers.stream()
                .filter(n -> Math.sqrt(n) % 1 == 0)
                .findFirst()
                .orElse(0);

        return String.valueOf(result);

    }
}
