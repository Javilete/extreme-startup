package com.extreme.startup.operators;

import java.util.List;
import java.util.regex.Matcher;

public class Larger extends Operator{

    private static Larger INSTANCE = null;

    public static Larger getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Larger();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        List<Integer> numbers = extractValues(matcher);
        int result = numbers.stream()
                .mapToInt(n -> n)
                .max()
                .orElse(0);

        return String.valueOf(result);

    }
}
