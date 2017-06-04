package com.extreme.startup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MatcherServiceShould {

    @Mock
    private Calculator calculator;

    private MatcherService matcherService;

    @Before
    public void setUp() throws Exception {
        matcherService = new MatcherService(calculator);
    }

    @Test
    public void callCalculatorForSumOperations() {
        String question = "what is 3 plus 16";

        matcherService.findMatch(question);

        verify(calculator).calculate(3, 16, (a,b) -> a + b);
    }

    @Test
    public void callCalculatorToGetTheLargest() {
        String question = "which of the following numbers is the largest: 807, 67";
        List<Integer> list = Arrays.asList(807, 67);

        matcherService.findMatch(question);

        verify(calculator).calculate(list);
    }

    @Test
    public void callCalculatorToGetTheLargestWithAnyLength() {
        String question = "which of the following numbers is the largest: 417, 67, 15, 120";
        List<Integer> list = Arrays.asList(417, 67, 15, 120);

        matcherService.findMatch(question);

        verify(calculator).calculate(list);
    }

    @Test
    public void callCalculatorToGetTheMultipliedNumbers() {
        String question = "what is 5 multiplied by 8";

        matcherService.findMatch(question);

        verify(calculator).calculate(5, 8, (a,b) -> a * b);
    }
}
