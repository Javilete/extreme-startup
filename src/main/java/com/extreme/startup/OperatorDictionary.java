package com.extreme.startup;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class OperatorDictionary {

    private static final String PLUS_PATTERN = ".*what is (\\d+) plus (\\d+)";

    private final Map<Pattern,Operator> patternOperator = new HashMap<>();

    public OperatorDictionary() {
        patternOperator.put(Pattern.compile(PLUS_PATTERN), Summer.getInstance());
    }

    public Operator getOperator(String question) {
        Optional<Pattern> patternOptional = patternOperator.keySet().stream()
                .map(p -> p.matcher(question))
                .filter(m -> m.matches())
                .map(m-> m.pattern())
                .findFirst();

        Pattern pattern = patternOptional.orElseThrow(() -> new RuntimeException());

        return patternOperator.get(pattern);
    }

}
