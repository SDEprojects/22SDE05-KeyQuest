package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import static com.game.JSONParser.getStringArray;

public class GameClient {

    public static void main(String[] args) throws IOException {

        String currentLocation = "foyer";
        System.out.println("Current location is " + currentLocation);

        JSONObject jsonObjectCommand = JSONParser.ReadJSON("command.json");
        JSONObject jsonObjectLocation = JSONParser.ReadJSON("location.json");

        Set<String> keysCommand = JSONParser.geyKeys(jsonObjectCommand);
        System.out.println("List of available commands: " + keysCommand);
        Set<String> keysLocation = JSONParser.geyKeys(jsonObjectLocation);
        System.out.println("List of available locations: " + keysLocation);

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
            JSONArray nextCommandsJsonArray = jsonObjectCommand.getJSONArray(phrase[0]);
            JSONArray nextLocationsJsonArray = jsonObjectLocation.getJSONArray(currentLocation);
            String[] nextCommands = getStringArray(nextCommandsJsonArray);
            String[] nextLocations = getStringArray(nextLocationsJsonArray);

            for (String nextLocation : nextLocations) {
                if (Arrays.asList(nextLocations).contains(phrase[1]) && (Arrays.asList(nextCommands).contains(phrase[1]))) {
                    currentLocation = phrase[1];
                    System.out.println("New location: " + currentLocation);
                    break;
                } else if (phrase[1].equals(currentLocation)) {
                    System.out.println("Already in " + phrase[1]);
                    break;
                } else if (!phrase[1].equals(nextLocation)) {
                    System.out.println("Cannot " + phrase[0] + ": " + currentLocation + " ---> " + phrase[1]);
                    break;
                } else if (!Arrays.asList(nextCommands).contains(phrase[1])) {
                    System.out.println("Cannot " + phrase[0] + " " + phrase[1]);
                    break;
                }
            }
        } else {
            System.out.println("Please try another command");
        }
    }
}
