package com.extreme.startup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MatcherServiceShould {

    @Mock
    private Calculator calculator;

    @Captor
    private ArgumentCaptor<BiFunction> biFunctionArgumentCaptor;

    @Captor
    private ArgumentCaptor<Function> functionArgumentCaptor;

    private MatcherService matcherService;

    @Before
    public void setUp() throws Exception {
        matcherService = new MatcherService(calculator);
    }

    @Test
    public void callCalculatorForSumOperations() {
        String question = "what is 3 plus 16";

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(3), eq(16), biFunctionArgumentCaptor.capture());
        assertEquals(19, biFunctionArgumentCaptor.getValue().apply(3,16));
    }

    @Test
    public void callCalculatorToGetTheLargest() {
        String question = "which of the following numbers is the largest: 807, 67";
        List<Integer> list = Arrays.asList(807, 67);

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(list), functionArgumentCaptor.capture());
        assertEquals(807, functionArgumentCaptor.getValue().apply(list));
    }

    @Test
    public void callCalculatorToGetTheLargestWithFourLength() {
        String question = "which of the following numbers is the largest: 417, 67, 15, 120";
        List<Integer> list = Arrays.asList(417, 67, 15, 120);

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(list), functionArgumentCaptor.capture());
        assertEquals(417, functionArgumentCaptor.getValue().apply(list));
    }

    @Test
    public void callCalculatorToGetTheMultipliedNumbers() {
        String question = "what is 5 multiplied by 8";

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(5), eq(8), biFunctionArgumentCaptor.capture());
        assertEquals(40, biFunctionArgumentCaptor.getValue().apply(5,8));
    }

    @Test
    public void callCalculatorToGetSquareAndCube() {
        String question = "which of the following numbers is both a square and a cube: 121, 249";
        List<Integer> list = Arrays.asList(121, 249);

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(list), functionArgumentCaptor.capture());
        assertEquals(121, functionArgumentCaptor.getValue().apply(list));
    }

    @Test
    public void callCalculatorToGetSquareAndCubeWithFourLength() {
        String question = "which of the following numbers is both a square and a cube: 236, 64, 592, 784";
        List<Integer> list = Arrays.asList(236, 64, 592, 784);

        matcherService.findMatch(question);

        verify(calculator).calculate(eq(list), functionArgumentCaptor.capture());
        assertEquals(64, functionArgumentCaptor.getValue().apply(list));
    }
}
