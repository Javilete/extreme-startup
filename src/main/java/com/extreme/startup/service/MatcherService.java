package com.extreme.startup.service;

import com.extreme.startup.TextDictionary;
import com.extreme.startup.operators.FibonacciOperator;
import com.extreme.startup.operators.Larger;
import com.extreme.startup.operators.Multiplier;
import com.extreme.startup.operators.Operator;
import com.extreme.startup.operators.PowOperator;
import com.extreme.startup.operators.PrimesOperator;
import com.extreme.startup.operators.SqrtCubeOperator;
import com.extreme.startup.operators.Substracter;
import com.extreme.startup.operators.Summer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherService {

    private static final String SUM_PATTERN = ".*what is (\\d+) plus (\\d+)";
    private static final String SUM_SEVERAL_PATTERN = ".*what is (\\d+) plus (\\d+) plus (\\d+)";
    private static final String SUSBSTRACT_PATTERN = ".*what is (\\d+) minus (\\d+)";
    private static final String MULTIPLY_PATTERN = ".*what is (\\d+) multiplied by (\\d+)";
    private static final String FIBONACCI_PATTERN = ".*what is the (\\d+)th number in the Fibonacci sequence";
    private static final String POW_PATTERN = ".*what is (\\d+) to the power of (\\d+)";
    private static final String LARGEST_SIZE_TWO_PATTERN = ".*which of the following numbers is the largest: (\\d+), (\\d+)";
    private static final String LARGEST_SIZE_FOUR_PATTERN = ".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)";
    private static final String SQUARE_CUBE_PATTERN = ".*which of the following numbers is both a square and a cube: (\\d+), (\\d+)";
    private static final String SQUARE_CUBE_SIZE_FOUR_PATTERN = ".*which of the following numbers is both a square and a cube: (\\d+), (\\d+), (\\d+), (\\d+)";
    private static final String PRIMES_PATTERN = ".*which of the following numbers are primes: (\\d+), (\\d+)";
    private static final String PRIMES_SIZE_FOUR_PATTERN = ".*which of the following numbers are primes: (\\d+), (\\d+), (\\d+), (\\d+)";

    private final Map<Pattern, Operator> patternDictionary = new HashMap<>();

    private final TextDictionary textDictionary;

    public MatcherService(TextDictionary textDictionary) {
        this.textDictionary = textDictionary;
        initializeDictionary();
    }

    private void initializeDictionary() {
        patternDictionary.put(Pattern.compile(SUM_PATTERN), Summer.getInstance());
        patternDictionary.put(Pattern.compile(SUM_SEVERAL_PATTERN), Summer.getInstance());
        patternDictionary.put(Pattern.compile(SUSBSTRACT_PATTERN), Substracter.getInstance());
        patternDictionary.put(Pattern.compile(MULTIPLY_PATTERN), Multiplier.getInstance());
        patternDictionary.put(Pattern.compile(FIBONACCI_PATTERN), FibonacciOperator.getInstance());
        patternDictionary.put(Pattern.compile(POW_PATTERN), PowOperator.getInstance());
        patternDictionary.put(Pattern.compile(LARGEST_SIZE_TWO_PATTERN), Larger.getInstance());
        patternDictionary.put(Pattern.compile(LARGEST_SIZE_FOUR_PATTERN), Larger.getInstance());
        patternDictionary.put(Pattern.compile(SQUARE_CUBE_PATTERN), SqrtCubeOperator.getInstance());
        patternDictionary.put(Pattern.compile(SQUARE_CUBE_SIZE_FOUR_PATTERN), SqrtCubeOperator.getInstance());
        patternDictionary.put(Pattern.compile(PRIMES_PATTERN), PrimesOperator.getInstance());
        patternDictionary.put(Pattern.compile(PRIMES_SIZE_FOUR_PATTERN), PrimesOperator.getInstance());
    }

    public String findMatch(String question) {
        Optional<Matcher> optMatcher = patternDictionary.keySet().stream()
                .map(p -> p.matcher(question))
                .filter(m -> m.matches())
                .findFirst();

        if (optMatcher.isPresent()) {
            Matcher matcher = optMatcher.get();
            Operator operator = patternDictionary.get(matcher.pattern());
            return operator.execute(matcher);
        }

        return textDictionary.getResponse(question.substring(question.indexOf("wh")));

    }
}
