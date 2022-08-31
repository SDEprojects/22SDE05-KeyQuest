package com.game;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.Set;

public class JSONParser {

    public static JSONObject ReadJSON(String filepath) {

        InputStream inputStream = TextParser.class.getResourceAsStream(filepath);
        if (inputStream == null) {
            throw new NullPointerException("Cannot find a file with commands list " + filepath);
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

    public static Set<String> geyKeys(JSONObject jsonObject) {
        return jsonObject.keySet();
    }

}
