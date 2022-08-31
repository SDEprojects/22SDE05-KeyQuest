package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TextParser {
    public static String[] parse() throws IOException {

        String[] phrase;
        try (
                Reader input = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(input)
        ) {
            StringWidget text = new StringWidget(reader, "Please enter text command: ", "Input invalid", "foyer", "kitchen");
            String parsedText = text.getInput();
            String updatedParsedText = parsedText.replaceAll("[^\\w\\s]", "");
            phrase = updatedParsedText.split("\\s+");
        }
        return phrase;
    }
}

