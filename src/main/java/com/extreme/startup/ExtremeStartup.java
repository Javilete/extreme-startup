package com.extreme.startup;

import com.extreme.startup.service.MatcherService;

import static spark.Spark.get;
import static spark.Spark.port;


public class ExtremeStartup {

    private final String teamName;
    private final MatcherService matcherService;


    public ExtremeStartup(String teamName, MatcherService matcherService) {
        this.teamName = teamName;
        this.matcherService = matcherService;
    }

    public static void main(String[] args) {
        TextDictionary textDictionary = new TextDictionary();
        MatcherService matcherService = new MatcherService(textDictionary);
        final ExtremeStartup server = new ExtremeStartup("team name", matcherService);
        port(1347);
        get("/", (request, response) -> {
            String question = request.queryParams("q");
            System.out.println(question);
            return server.answer(question);
        });
    }

    public String answer(String s) {
        return matcherService.findMatch(s);
    }
}
