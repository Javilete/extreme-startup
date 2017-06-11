package com.extreme.startup;

import com.extreme.startup.service.MatcherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExtremeStartupShould {

    @Mock
    private MatcherService matcherService;

    private ExtremeStartup startup;

    @Before
    public void setUp() throws Exception {
        startup = new ExtremeStartup("TeamSpirit", matcherService);
    }

    @Test
    public void shouldCallMatcherService() {
        String question = "what is the sum of 8 and 25\n";

        startup.answer(question);

        verify(matcherService).findMatch(question);
    }


//    private final com.extreme.startup.ExtremeStartup server = new com.extreme.startup.ExtremeStartup("spark team", matcherService);
//
//    @Test
//    public void should_accept_missing_input() {
//        assertEquals(server.answer(null), "spark team");
//    }
//
//    @Test
//    public void should_answer_name() {
//        assertEquals(server.answer("what is your name"), "spark team");
//    }
//
//    @Test
//    public void should_add_numbers() {
//        assertEquals(server.answer("what is the sum of 4 and 12"), "16");
//    }

}
