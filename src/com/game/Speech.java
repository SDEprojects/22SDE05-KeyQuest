package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

import static com.game.JSONParser.getStringArray;

public class Speech {
    private String name;
    private String type;
    private String description;
    private String[] items;
    private String[] speech;
    private final String characterKey = "characters";

    JSONObject jsonObjectCharacter = JSONParser.ReadJSON("character.json");
    JSONObject characters = jsonObjectCharacter.getJSONObject(characterKey);

    public Speech(String name) {
        this.name = name;
        String typeKey = "type";
        String descriptionKey = "description";
        String itemsKey = "items";
        String speechKey = "speech";
        JSONObject information = characters.getJSONObject(name);
        type = information.getString(typeKey);
        description = information.getString(descriptionKey);
        JSONArray itemsArray = information.getJSONArray(itemsKey);
        items = getStringArray(itemsArray);
        JSONArray speechArray = information.getJSONArray(speechKey);
        speech = getStringArray(speechArray);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getSpeech() {
        return speech;
    }
    public void setSpeech(String[] speech) {
        this.speech = speech;
    }

    @Override
    public String toString() {
        return "Speech{" +
                "name'" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", items=" + Arrays.toString(items) +
                ", speech=" + Arrays.toString(speech) +
                '}';
    }
}
