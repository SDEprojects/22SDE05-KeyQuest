package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import static com.game.JSONParser.getStringArray;

public class GameClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        JSONObject jsonObjectCommand = JSONParser.ReadJSON("command.json");
        JSONObject jsonObjectLocation = JSONParser.ReadJSON("location.json");
        JSONObject jsonObjectLocationStart = JSONParser.ReadJSON("locationv3.json");

        TitlePage.title();
        Screen.DivideScreen();
        String currentLocation = jsonObjectLocationStart.getString("startingRoom");
        String[] phrase;

        Introduction introduction = new Introduction();
        System.out.println(introduction.getStory());
        System.out.println(introduction.getPlayer());
        System.out.println(introduction.getObjective());
        System.out.println(introduction.getWin());
        Screen.DivideScreen();

        while (true) {
            String firstCommand = GameManager.start();
            Screen.ClearScreen();
            if (Objects.equals(firstCommand, "quit")) {
                GameManager.quit();
                break;
            }
            if (Objects.equals(firstCommand, "start")) {
                System.out.println("Type 'help' to get available commands, type 'look' to get list of things you are looking at.");
                Set<String> keysCommand = JSONParser.getKeys(jsonObjectCommand);
                System.out.println("List of available commands: " + keysCommand);
                Set<String> keysLocation = JSONParser.getKeys(jsonObjectLocation);
                System.out.println("List of available locations: " + keysLocation);
                Screen.DivideScreen();
                do {
                    System.out.println("\nCurrent location is " + currentLocation);
                    JSONArray listNextLocations = jsonObjectLocation.getJSONArray(currentLocation);
                    Location location = new Location(currentLocation);
                    System.out.println(location.getDescription());
                    System.out.println("\nList of furniture: " + Arrays.toString(location.getFurniture()));
                    System.out.println("List of items: " + Arrays.toString(location.getItems()));
                    System.out.println("\nYou can go to: " + listNextLocations);
                    phrase = TextParser.read();
                    boolean isValidVerb = false;
                    boolean isValidLocation = false;
                    Screen.ClearScreen();
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
                    } else if(Objects.equals(phrase[0], "look")) {
                        System.out.println("\nYou are looking at: " + Arrays.toString(location.getFurniture()));
                    }
                    else if(Objects.equals(phrase[0], "talk")) {
                        System.out.println("\nWho would you like to talk to: " + Arrays.toString(location.getFurniture()));
                    }
                    else if (Objects.equals(phrase[0], "help")) {
                        System.out.println("\nList of available commands: " + keysCommand);
                    } else if (Objects.equals(phrase[0], "quit")) {
                        String confirmation = GameManager.confirmQuit();
                        if (Objects.equals(confirmation, "yes")) {
                            GameManager.quit();
                            break;
                        } else if (Objects.equals(confirmation, "no")) {
                            phrase[0] = "start";
                        }
                    } else {
                        System.out.println("Please try another command. Please type 'help' for more information.");
                    }
                } while (!Objects.equals(phrase[0], "quit"));
                break;
            }
        }
    }
}
