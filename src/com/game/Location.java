package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

import static com.game.JSONParser.getStringArray;

public class Location {

    private String name;
    private String description;
    private String[] items;
    private String[] furniture;
    private String[] door;
    private String[] character;
    private String[] directions;
    private final String roomsKey = "rooms";

    JSONObject jsonObjectLocation = JSONParser.ReadJSON("locationv3.json");
    JSONObject rooms = jsonObjectLocation.getJSONObject(roomsKey);

    public Location(String name) {
        this.name = name;
        String descriptionKey = "description";
        String itemsKey = "items";
        String furnitureKey = "furniture";
        String doorKey = "door";
        String characterKey = "character";
        String directionsKey = "directions";
        JSONObject information = rooms.getJSONObject(name);
        description = information.getString(descriptionKey);
        JSONArray itemsArray = information.getJSONArray(itemsKey);
        items = getStringArray(itemsArray);
        JSONArray furnitureArray = information.getJSONArray(furnitureKey);
        furniture = getStringArray(furnitureArray);
        JSONArray doorArray = information.getJSONArray(doorKey);
        door = getStringArray(doorArray);
        JSONArray characterArray = information.getJSONArray(characterKey);
        character = getStringArray(characterArray);
        JSONArray directionsArray = information.getJSONArray(directionsKey);
        directions = getStringArray(directionsArray);
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

    public String[] getFurniture() {
        return furniture;
    }

    public void setFurniture(String[] furniture) {
        this.furniture = furniture;
    }

    public String[] getDoor() {
        return door;
    }

    public void setDoor(String[] door) {
        this.door = door;
    }

    public String[] getCharacter() {
        return character;
    }

    public void setCharacter(String[] character) {
        this.character = character;
    }

    public String[] getDirections() {
        return directions;
    }

    public void setDirections(String[] directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", items=" + Arrays.toString(items) +
                ", furniture=" + Arrays.toString(furniture) +
                ", door=" + Arrays.toString(door) +
                ", character=" + Arrays.toString(character) +
                ", directions=" + Arrays.toString(directions) +
                '}';
    }
}
