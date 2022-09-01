package com.game;

import java.util.Scanner;

public class TextParser {

    public static String[] read() {
        String[] phrase;
        Scanner scanner = new Scanner(System.in);
        String parsedText = scanner.nextLine();
        String updatedParsedText = parsedText.replaceAll("[^\\w\\s]", "");
        phrase = updatedParsedText.split("\\s+");
        return phrase;
    }
}

