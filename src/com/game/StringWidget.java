package com.game;

import java.io.BufferedReader;
import java.io.IOException;

public class StringWidget extends InputWidget<String> {

    private final BufferedReader reader;
    private final String promptPattern;
    private final String errorMessagePattern;
    private final  String location;
    private final  String direction;

    public StringWidget(BufferedReader reader, String promptPattern, String errorMessagePattern, String location, String direction) {
        this.reader = reader;
        this.promptPattern = promptPattern;
        this.errorMessagePattern = errorMessagePattern;
        this.location = location;
        this.direction = direction;
    }

    @Override
    public String getInput() {
        String input = null;
        System.out.printf(promptPattern, location, direction);
        do {
            try {
                input = reader.readLine().trim().toLowerCase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                System.out.printf(errorMessagePattern, location, direction);
            }
        } while (input == null);
        return input;
    }
}
