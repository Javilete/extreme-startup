package com.extreme.startup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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

        if (sumMatcher.matches()) {
            return calculator.calculate(
                    Integer.parseInt(sumMatcher.group(1)),
                    Integer.parseInt(sumMatcher.group(2)),
                    (a, b) -> a + b);
        }

        Matcher largestMatcher =
                Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);

        if (largestMatcher.matches()) {
            List<Integer> numbers = convertToList(largestMatcher);
            return calculator.calculate(numbers, maxOperation);
        }

        Matcher largestMatcherWithFour =
                Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);

        if (largestMatcherWithFour.matches()) {
            List<Integer> numbers = convertToList(largestMatcherWithFour);
            return calculator.calculate(numbers, maxOperation);
        }

        Matcher multiplyMatcher =
                Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(question);

        if (multiplyMatcher.matches()) {
            return calculator.calculate(
                    Integer.parseInt(multiplyMatcher.group(1)),
                    Integer.parseInt(multiplyMatcher.group(2)),
                    (a, b) -> a * b);
        }

        Matcher sqrtCubeMatcher =
                Pattern.compile(".*which of the following numbers is both a square and a cube: (\\d+), (\\d+)").matcher(question);

        if (sqrtCubeMatcher.matches()) {
            List<Integer> numbers = convertToList(sqrtCubeMatcher);
            return calculator.calculate(numbers, sqrtOperation);
        }

        Matcher sqrtCubeWithFourMatcher =
                Pattern.compile(".*which of the following numbers is both a square and a cube: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);

        if (sqrtCubeWithFourMatcher.matches()) {
            List<Integer> numbers = convertToList(sqrtCubeWithFourMatcher);
            return calculator.calculate(numbers, sqrtOperation);
        }

        return null;
    }

    private List<Integer> convertToList(Matcher matcher) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= matcher.groupCount(); i++) {
            numbers.add(Integer.parseInt(matcher.group(i)));
        }

        return numbers;
    }

    private Function<List<Integer>,Integer> maxOperation = l -> l.stream().mapToInt(n -> n).max().orElse(0);
    private Function<List<Integer>,Integer> sqrtOperation = l -> l.stream().filter(n -> Math.sqrt(n) % 1 == 0).findFirst().orElse(0);
}
