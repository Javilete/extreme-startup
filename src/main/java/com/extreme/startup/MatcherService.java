package com.extreme.startup;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherService {

    private final Calculator calculator;

    public MatcherService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String findMatch(String question) {
        Matcher sumMatcher =
                Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);

        if(sumMatcher.matches()) {
            return calculator.calculate(
                    Integer.parseInt(sumMatcher.group(1)),
                    Integer.parseInt(sumMatcher.group(2)),
                    (a,b) -> a + b);
        }

        Matcher largestMatcher =
                Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);

        if(largestMatcher.matches()) {
            return getLargest(largestMatcher);
        }

        Matcher largestMatcherWithFour =
                Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);

        if(largestMatcherWithFour.matches()) {
            return getLargest(largestMatcherWithFour);
        }

        Matcher multiplyMatcher =
                Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(question);

        if(multiplyMatcher.matches()) {
            return calculator.calculate(
                    Integer.parseInt(multiplyMatcher.group(1)),
                    Integer.parseInt(multiplyMatcher.group(2)),
                    (a,b) -> a * b);
        }

        return null;
    }

    private String getLargest(Matcher matcher) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= matcher.groupCount(); i++) {
            numbers.add(Integer.parseInt(matcher.group(i)));
        }

        return calculator.calculate(numbers);
    }
}
