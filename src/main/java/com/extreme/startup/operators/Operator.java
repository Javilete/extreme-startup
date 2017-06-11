package com.extreme.startup.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public abstract class Operator {

    public abstract String execute(Matcher matcher);

    protected List<Integer> extractValues(Matcher matcher) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            numbers.add(Integer.parseInt(matcher.group(i)));
        }

        return numbers;
    }
}
