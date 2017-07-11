package com.extreme.startup.service;

import com.extreme.startup.TextDictionary;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

public class MatcherServiceShould {

    private TextDictionary textDictionary;
    private MatcherService matcherService;

    @Before
    public void setUp() throws Exception {
        textDictionary = new TextDictionary();
        matcherService = new MatcherService(textDictionary);
    }

    @Test
    public void returnSumWhenTheQuestionIsAplus() {
        String question = "what is 3 plus 16";

        String result = matcherService.findMatch(question);

        assertThat(result, is("19"));
    }

    @Test
    public void returnMultiplyWhenTheQuestionIsAmultiplied() {
        String question = "what is 5 multiplied by 8";

        String result = matcherService.findMatch(question);

        assertThat(result, is("40"));
    }

    @Test
    public void returnTheLargestBetweenNumbersGiven() {
        String question = "which of the following numbers is the largest: 807, 67";

        String result = matcherService.findMatch(question);

        assertThat(result, is("807"));
    }

    @Test
    public void returnTheSquareAndCubeBetweenNumbersGiven() {
        String question = "which of the following numbers is both a square and a cube: 121, 249";

        String result = matcherService.findMatch(question);

        assertThat(result, is("121"));
    }

    @Test
    public void returnThePrimeNumbersFromAsetGiven() {
        String question = "which of the following numbers are primes: 901, 223";

        String result = matcherService.findMatch(question);

        assertThat(result, is("223"));
    }

    @Test
    public void returnTheTextResultWhenThereIsNoMatchForAPattern() {
        String question = "who is the Prime Minister of Great Britain";

        String result = matcherService.findMatch(question);

        assertThat(result, is("Theresa May"));
    }

    @Test
    public void returnSubstractWhenTheQuestionIsMinus() {
        String question = "what is 3 minus 8";

        String result = matcherService.findMatch(question);

        assertThat(result, is("-5"));
    }

    @Test
    public void returnTheNumberSpecifyInTheFibonacciSequence() {
        String question = "what is the 10th number in the Fibonacci sequence";

        String response = matcherService.findMatch(question);

        assertThat(response, is("55"));
    }

    @Test
    public void callPowExecuteMethod() {
        String question = "what is 2 to the power of 11";

        String response = matcherService.findMatch(question);

        assertThat(response, is("2048"));
    }

    @Test
    public void shouldReturnSumOfMoreThanTwoNumbers() {
        String question = "what is 12 plus 7 plus 2";

        String response = matcherService.findMatch(question);

        assertThat(response, is("21"));
    }
}
