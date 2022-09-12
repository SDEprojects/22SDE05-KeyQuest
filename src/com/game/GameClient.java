package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

import static com.game.JSONParser.*;

public class GameClient {

    public static void main(String[] args) throws InterruptedException {
        JSONObject jsonObjectCommand = getJsonObjectCommand();
        TitlePage.title();
        Screen.DivideScreen();
        String currentLocation = getStartingRoom();
        String[] phrase;
        BufferedReader in;
        String input;
        String output = "";
        in = new BufferedReader(new InputStreamReader(System.in));

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

            //Save and Load Work in Progress
            /**
             if (Objects.equals(firstCommand, "save")){
             GameManager.saveGame();
             GameManager.quit();
             break;
             }
             if (Objects.equals(firstCommand, "load")){
             GameManager.loadGame();
             break;
             }
             **/

            if (Objects.equals(firstCommand, "start")) {
                System.out.println("Type 'help' to get available commands, type 'look' to get list of things you are looking at.");
                System.out.println("List of available commands: " + getKeyCommands());
                System.out.println("List of available locations: " + getListOfLocations());
                List<String> inventory = new ArrayList<>();
                Character cat = new Character("cat");
                Character dog = new Character("dog");
                Screen.DivideScreen();
                do {
                    System.out.println("\nCurrent location is " + currentLocation);
                    Screen.DivideScreen();
                    Location location = new Location(currentLocation);
                    String[] listNextLocations = location.getDirections();
                    String[] characters = location.getCharacter();
                    System.out.println(location.getDescription());
                    //System.out.println("\nList of furniture: " + Arrays.toString(location.getFurniture()));
                    if (characters.length != 0) {
                        if (Arrays.asList(characters).contains("cat")) {
                            System.out.println(cat.getDescription());
                        } else if (Arrays.asList(characters).contains("dog")) {
                            System.out.println(dog.getDescription());
                        }
                    }
                    System.out.println("List of items: " + Arrays.toString(location.getItems()));
                    Screen.DivideScreen();
                    System.out.println("You can go to: " + Arrays.toString(listNextLocations));
                    Screen.DivideScreen();
                    phrase = TextParser.read();
                    String item;
                    Set<String> character = getCharacters();
                    boolean isValidVerb = false;
                    boolean isValidLocation = false;
                    boolean isValidItem = false;
                    boolean isValidCharacter = false;
                    Screen.ClearScreen();
                    for (int i = 0; i < phrase.length; i++) {
                        if (phrase.length == 2) {
                            isValidVerb = jsonObjectCommand.has(phrase[0]);
                            isValidLocation = getRooms().has(phrase[1]);
                            for (int j = 0; j < getLocationItems(currentLocation).length; j++) {
                                item = getLocationItems(currentLocation)[j];
                                if (Objects.equals(item, phrase[1])) {
                                    isValidItem = true;
                                }
                            }
                            if (character.contains(phrase[1])) {
                                isValidCharacter = true;
                            }
                        } else if (phrase.length == 1) {
                            isValidVerb = jsonObjectCommand.has(phrase[0]);
                        }
                    }
                    if (isValidVerb && isValidLocation) {
                        JSONArray nextCommandsJsonArray = jsonObjectCommand.getJSONArray(phrase[0]);
                        String[] nextLocations = location.getDirections();
                        String[] nextCommands = getStringArray(nextCommandsJsonArray);
                        for (String nextLocation : nextLocations) {
                            Location nextRoomLocation = new Location(phrase[1]);
                            String[] charactersInNextLocation = nextRoomLocation.getCharacter();
                            if (Arrays.asList(nextLocations).contains(phrase[1]) && (Arrays.asList(nextCommands).contains(phrase[1]))) {
                                if (inventory.contains("key") && Objects.equals(currentLocation, "garage") && Objects.equals(phrase[1], "garden")) {
                                    System.out.println(introduction.getWin());
                                    currentLocation = phrase[1];
                                    Screen.DivideScreen();
                                    GameManager.quit();
                                    phrase[0] = "quit";
                                    break;
                                } else if (!inventory.contains("key") && Objects.equals(currentLocation, "garage") && Objects.equals(phrase[1], "garden")) {
                                    System.out.println(introduction.getPrompt());
                                    break;
                                } else if (inventory.isEmpty() && charactersInNextLocation.length !=0) {
                                    System.out.println(introduction.getLose());
                                    System.out.println("Get items to distract cat and dog first, before going to " + phrase[1]);
                                    Screen.DivideScreen();
                                    GameManager.quit();
                                    phrase[0] = "quit";
                                    break;
                                } else if(!inventory.isEmpty() && characters.length != 0) {
                                    System.out.println("Distract cat or dog, throw item.");
                                }
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
                    } else if (isValidItem) {
                        if ((inventory.contains(phrase[1]) && Objects.equals(phrase[0], "get")) || (inventory.contains(phrase[1]) && Objects.equals(phrase[0], "pick")) || (inventory.contains(phrase[1]) && Objects.equals(phrase[0], "collect") || (inventory.contains(phrase[1]) && Objects.equals(phrase[0], "grab")))) {
                            System.out.println("Inventory already has " + phrase[1]);
                            System.out.println(inventory);
                        } else if ((inventory.contains(phrase[1]) && Objects.equals(phrase[0], "drop")) || (inventory.contains(phrase[1]) && Objects.equals(phrase[0], "eat")) || (inventory.contains(phrase[1]) && Objects.equals(phrase[0], "throw"))) {
                            inventory.remove(phrase[1]);
                            System.out.println("Removed " + phrase[1] + " to the inventory");
                            System.out.println(inventory);
                        } else if ((inventory.contains(phrase[1]) && !Objects.equals(phrase[0], "get")) || (inventory.contains(phrase[1]) && !Objects.equals(phrase[0], "pick")) || (inventory.contains(phrase[1]) && !Objects.equals(phrase[0], "collect")) || (inventory.contains(phrase[1]) && !Objects.equals(phrase[0], "grab"))) {
                            System.out.println("Cannot " + phrase[0] + " " + phrase[1]);
                        } else if (!inventory.contains(phrase[1]) && (Objects.equals(phrase[0], "drop") || Objects.equals(phrase[0], "eat") || Objects.equals(phrase[0], "throw"))) {
                            System.out.println("Inventory doesn't  contain " + phrase[1]);
                            System.out.println(inventory);
                        } else {
                            inventory.add(phrase[1]);
                            System.out.println("Added " + phrase[1] + " to the inventory");
                            System.out.println(inventory);
                        }
                    } else if (Objects.equals(phrase[0], "inventory") || (Objects.equals(phrase[0], "show") && Objects.equals(phrase[1], "inventory"))) {
                        System.out.println("List of inventory items " + inventory);
                    } else if (Objects.equals(phrase[0], "talk")) {
                        System.out.println("\nWho would you like to talk to: " + getCharacters());
                        if (isValidCharacter && Objects.equals(phrase[1], "dog")) {
                            System.out.println("You are talking to " + phrase[1]);
                            System.out.println(getDogSpeech());
                        } else if (isValidCharacter && Objects.equals(phrase[1], "cat")) {
                            System.out.println("You are talking to " + phrase[1]);
                            System.out.println(getCatSpeech());
                        }
                    } else if (Objects.equals(phrase[0], "help")) {
                        System.out.println("\nList of available commands: " + getKeyCommands());
                    } else if (Objects.equals(phrase[0], "look")) {
                        Set<String> listOfItems = getKeys(jsonObjectItem);
                        if (listOfItems.contains(phrase[1])) {
                            Item itemInformation = new Item(phrase[1]);
                            System.out.println("You can find " + phrase[1] + " in " + itemInformation.getRoom());
                            System.out.println(getLookItem(phrase[1]));
                            System.out.println(itemInformation.getUsage());
                        }
                    } else if (Objects.equals(phrase[0], "quit")) {
                        String confirmation = GameManager.confirmQuit();
                        if (Objects.equals(confirmation, "yes")) {
                            GameManager.quit();
                            Screen.DivideScreen();
                            break;
                        } else if (Objects.equals(confirmation, "no")) {
                            phrase[0] = "start";
                        }
                    } else {
                        System.out.println("Please try another command. Please type 'help' for more information.");
                    }
                }
                while (!Objects.equals(phrase[0], "quit"));
                break;
            }
        }
    }
}