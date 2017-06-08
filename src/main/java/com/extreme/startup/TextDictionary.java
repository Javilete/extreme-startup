package com.extreme.startup;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TextDictionary {

    private final Map<String,String> questions = new HashMap<>();

    public TextDictionary() {
        questions.put("who is the Prime Minister of Great Britain", "Theresa May");
        questions.put("which city is the Eiffel tower in", "Paris");
        questions.put("who played James Bond in the film Dr No", "Sean Connery");
        questions.put("what colour is a banana", "yellow");
        questions.put("what currency did Spain use before the Euro", "peseta");
    }

    public String getResponse(String question) {
        return Optional.ofNullable(questions.get(question)).orElse("Add the question");
    }
}
