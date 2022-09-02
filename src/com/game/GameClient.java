package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

import static com.game.JSONParser.getStringArray;

public class GameClient {
    public static void main(String[] args) throws InterruptedException {
        JSONObject jsonObjectCommand = JSONParser.ReadJSON("command.json");
        JSONObject jsonObjectLocation = JSONParser.ReadJSON("location.json");
        JSONObject jsonObjectLocationStart = JSONParser.ReadJSON("locationv3.json");

        TitlePage.title();
        String currentLocation = jsonObjectLocationStart.getString("startingRoom");
        String[] phrase;

        JSONObject jsonObjectIntroduction = JSONParser.ReadJSON("intro.json");
        String story = jsonObjectIntroduction.getString("story");
        String objective = jsonObjectIntroduction.getString("objective");
        String player = jsonObjectIntroduction.getString("player");
        String win = jsonObjectIntroduction.getString("win");
        System.out.println(story);
        System.out.println(player);
        System.out.println(objective);
        System.out.println(win);

        while (true) {
            String firstCommand = GameManager.start();
            if (Objects.equals(firstCommand, "quit")) {
                GameManager.quit();
                break;
            }
            if (Objects.equals(firstCommand, "start")) {
                Set<String> keysCommand = JSONParser.getKeys(jsonObjectCommand);
                System.out.println("List of available commands: " + keysCommand);
                Set<String> keysLocation = JSONParser.getKeys(jsonObjectLocation);
                System.out.println("List of available locations: " + keysLocation);
                System.out.println();
                do {
                    System.out.println();
                    System.out.println("Current location is " + currentLocation);
                    JSONArray listNextLocations = jsonObjectLocation.getJSONArray(currentLocation);
                    Location location = new Location(currentLocation);
                    System.out.println(location.getDescription());
                    System.out.println("List of furniture: " + Arrays.toString(location.getFurniture()));
                    System.out.println("List of items: " + Arrays.toString(location.getItems()));
                    System.out.println("You can go to " + listNextLocations);
                    phrase = TextParser.read();
                    boolean isValidVerb = false;
                    boolean isValidLocation = false;

                    for (int i = 0; i < phrase.length; i++) {
                        if (phrase.length == 2) {
                            isValidVerb = jsonObjectCommand.has(phrase[0]);
                            isValidLocation = jsonObjectLocation.has(phrase[1]);
                        } else if (phrase.length == 1) {
                            isValidVerb = jsonObjectCommand.has(phrase[0]);
                        }
                    }
                    if (isValidVerb && isValidLocation) {
                        JSONArray nextCommandsJsonArray = jsonObjectCommand.getJSONArray(phrase[0]);
                        JSONArray nextLocationsJsonArray = jsonObjectLocation.getJSONArray(currentLocation);
                        String[] nextCommands = getStringArray(nextCommandsJsonArray);
                        String[] nextLocations = getStringArray(nextLocationsJsonArray);
                        for (String nextLocation : nextLocations) {
                            if (Arrays.asList(nextLocations).contains(phrase[1]) && (Arrays.asList(nextCommands).contains(phrase[1]))) {
                                currentLocation = phrase[1];
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
                    } else if (Objects.equals(phrase[0], "quit")) {
                        String confirmation = GameManager.confirmQuit();
                        if (Objects.equals(confirmation, "yes")) {
                            GameManager.quit();
                            break;
                        } else if (Objects.equals(confirmation, "no")) {
                            phrase[0] = "start";
                        }
                    } else {
                        System.out.println("Please try another command");
                    }
                } while (!Objects.equals(phrase[0], "quit"));
                break;
            }
        }
    }
}
