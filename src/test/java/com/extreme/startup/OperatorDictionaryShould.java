package com.extreme.startup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OperatorDictionaryShould {

    private OperatorDictionary dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new OperatorDictionary();
    }

    @Test
    public void returnOperatorWhenApatternFoundMatching() {
        String question = "what is 3 plus 16";

        Operator operator = dictionary.getOperator(question);

        assertTrue(operator.getClass().equals(Summer.getInstance().getClass()));
    }
}
