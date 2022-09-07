package com.game;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.Set;

public class JSONParser {
    static JSONObject jsonObjectIntroduction = JSONParser.ReadJSON("intro.json");
    static JSONObject jsonObjectLocation = JSONParser.ReadJSON("locationv3.json");
    static JSONObject rooms = jsonObjectLocation.getJSONObject("rooms");

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

//    public static String getIntroduction(String key) {
//        return jsonObjectIntroduction.getString(key);
//    }

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

    public static String getLocationString (String room, String name) {
        JSONObject information = rooms.getJSONObject(room);
        return information.getString(name);
    }

    public static  String[] getLocationStringArray (String room, String key) {
        JSONObject information = rooms.getJSONObject(room);
        JSONArray jsonArray = information.getJSONArray(key);
        return getStringArray(jsonArray);
    }
}
