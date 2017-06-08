package com.extreme.startup;

import java.util.List;
import java.util.regex.Matcher;

public class Summer extends Operator{

    private static Summer INSTANCE = null;

    private Summer() {

    }

    public static Summer getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Summer();
        }
        return INSTANCE;
    }

    @Override
    public String execute(Matcher matcher) {
        List<Integer> numbers = extractValues(matcher);
        int result = numbers.stream()
                .mapToInt(n -> n)
                .sum();

        return String.valueOf(result);
    }
}
