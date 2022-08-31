package com.game;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

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

    public static void main(String[] args) throws IOException {

        String currentLocation = "foyer";
        System.out.println("Current location is " + currentLocation);

        String fileNameCommand = "command.json";
        String fileNameLocation = "location.json";

        InputStream inputStreamCommand = TextParser.class.getResourceAsStream(fileNameCommand);
        if (inputStreamCommand == null) {
            throw new NullPointerException("Cannot find a file with commands list " + fileNameCommand);
        }

        InputStream inputStreamLocation = TextParser.class.getResourceAsStream(fileNameLocation);
        if (inputStreamLocation == null) {
            throw new NullPointerException("Cannot find a file with locations list " + fileNameLocation);
        }

        JSONTokener jsonCommand = new JSONTokener(inputStreamCommand);
        JSONObject jsonObjectCommand = new JSONObject(jsonCommand);
        JSONTokener jsonLocation = new JSONTokener(inputStreamLocation);
        JSONObject jsonObjectLocation = new JSONObject(jsonLocation);

        String[] phrase = TextParser.parse();

        for (String s : phrase) {
            System.out.println(s);
        }

        boolean isValidVerb = false;
        boolean isValidLocation = false;

        for (int i = 0; i < phrase.length; i++) {
            try {
                isValidVerb = jsonObjectCommand.has(phrase[0]);
                isValidLocation = jsonObjectLocation.has(phrase[1]);
            } catch (Exception e) {
                throw new RuntimeException("Command not recognized");
            }
        }
        System.out.println(isValidVerb);
        System.out.println(isValidLocation);

        if (isValidVerb && isValidLocation) {
            JSONArray nextCommands = jsonObjectCommand.getJSONArray(phrase[0]);
            JSONArray nextLocations = jsonObjectLocation.getJSONArray(currentLocation);
            for (Object nextLocation : nextLocations) {
                for (Object value : nextCommands) {
                    if (phrase[1].equals(value.toString()) && phrase[1].equals(nextLocation.toString()) && !phrase[1].equals(currentLocation)) {
                        currentLocation = (String) nextLocation;
                        System.out.println("New location: " + currentLocation);
                        break;
                    } else if (phrase[1].equals(currentLocation)) {
                        System.out.println("Already in " + phrase[1]);
                        break;
                    } else if (!phrase[1].equals(nextLocation.toString())) {
                        System.out.println("Cannot " + phrase[0] + ": " + currentLocation + "--->" + phrase[1]);
                        break;
                    }
                }
                break;
            }
        } else {
            System.out.println("Please try another command");
        }
    }
}

