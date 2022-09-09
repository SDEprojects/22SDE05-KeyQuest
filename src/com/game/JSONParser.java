package com.game;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.Set;

public class JSONParser {
    static JSONObject jsonObjectIntroduction = JSONParser.ReadJSON("intro.json");
    static JSONObject jsonObjectLocation = JSONParser.ReadJSON("locationv3.json");
    static JSONObject jsonObjectCommand = JSONParser.ReadJSON("command.json");
    static JSONObject jsonObjectSpeech = JSONParser.ReadJSON("speech.json");

    static JSONObject rooms = jsonObjectLocation.getJSONObject("rooms");
    static String startingRoom = jsonObjectLocation.getString("startingRoom");
    static String endingRoom = jsonObjectLocation.getString("endingRoom");
    static JSONObject dogSpeech = jsonObjectSpeech.getJSONObject("dog");
    static JSONObject catSpeech = jsonObjectSpeech.getJSONObject("cat");
    static JSONObject jsonObjectItem = JSONParser.ReadJSON("items.json");

    public static JSONObject ReadJSON(String fileName) {

        InputStream inputStream = JSONParser.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new NullPointerException("Cannot find a file " + fileName);
        }

        JSONTokener jsonTokener = new JSONTokener(inputStream);
        return new JSONObject(jsonTokener);
    }

    public static String[] getStringArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return new String[0];
        }
        String[] array = new String[jsonArray.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = jsonArray.optString(i);
        }
        return array;
    }

    public static Set<String> getKeys(JSONObject jsonObject) {
        return jsonObject.keySet();
    }

    public static JSONObject getRooms() {
        return rooms;
    }

    public static String getStartingRoom() {
        return startingRoom;
    }

    public static String getEndingRoom() {
        return endingRoom;
    }

    public static JSONObject getJsonObjectCommand() {
        return jsonObjectCommand;
    }

    public static String getIntroductionStory() {
        return jsonObjectIntroduction.getString("story");
    }

    public static String getIntroductionPlayer() {
        return jsonObjectIntroduction.getString("player");
    }

    public static String getIntroductionObjective() {
        return jsonObjectIntroduction.getString("objective");
    }

    public static String getIntroductionWin() {
        return jsonObjectIntroduction.getString("win");
    }

    public static String getLocationDescription (String name) {
        JSONObject information = getRooms().getJSONObject(name);
        return information.getString("description");
    }

    public static String[] getLocationItems (String name) {
        JSONObject information = getRooms().getJSONObject(name);
        JSONArray jsonArray = information.getJSONArray("items");
        return getStringArray(jsonArray);
    }

    public static String[] getLocationFurniture (String name) {
        JSONObject information = getRooms().getJSONObject(name);
        JSONArray jsonArray = information.getJSONArray("furniture");
        return getStringArray(jsonArray);
    }

    public static String[] getLocationDoor (String name) {
        JSONObject information = getRooms().getJSONObject(name);
        JSONArray jsonArray = information.getJSONArray("door");
        return getStringArray(jsonArray);
    }

    public static String[] getLocationCharacter (String name) {
        JSONObject information = getRooms().getJSONObject(name);
        JSONArray jsonArray = information.getJSONArray("character");
        return getStringArray(jsonArray);
    }

    public static String[] getLocationDirections(String name) {
        JSONObject information = getRooms().getJSONObject(name);
        JSONArray jsonArray = information.getJSONArray("directions");
        return getStringArray(jsonArray);
    }

    // The following work with Speech.java

    public static Set<String> getCharacters() {
        return JSONParser.getKeys(jsonObjectSpeech);
    }


    public static String getDogSpeech () {
        switch (getRandomNumber(3)) {
            case 0:
                return dogSpeech.getString("speech1");
            case 1:
                return dogSpeech.getString("speech2");
            case 2:
                return dogSpeech.getString("speech3");
            default:
                return "This is a dog";
        }
    }

    public static String getCatSpeech () {
        switch (getRandomNumber(3)) {
            case 0:
                return catSpeech.getString("speech1");
            case 1:
                return catSpeech.getString("speech2");
            case 2:
                return catSpeech.getString("speech3");
            default:
                return "This is a cat";
        }
    }

    public static Set<String> getKeyCommands() {
        return JSONParser.getKeys(jsonObjectCommand);
    }

    public static String[] getCommands(String name) {
        JSONArray jsonArray = jsonObjectCommand.getJSONArray(name);
        return getStringArray(jsonArray);
    }

    public static Set<String> getListOfLocations() {
        return JSONParser.getKeys(getRooms());
    }

    public static  String getItemName() {
        return jsonObjectItem.getString("name");
    }
    public static String getItemRoom() {
        return jsonObjectItem.getString("room");
    }
    public static String getItemFurniture() {
        return jsonObjectItem.getString("furniture");
    }
    public static String getItemUsage(){
        return jsonObjectItem.getString("usage");
    }

    public static int getRandomNumber(int numberOfKeys) {
        return (int) (Math.random() * numberOfKeys + 1);
    }
}
