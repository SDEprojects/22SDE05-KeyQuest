package com.game;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

import static com.game.JSONParser.*;

public class Location {

    private String name;
    private String description;
    private String[] items;
    private String[] furniture;
    private String[] door;
    private String[] character;
    private String[] directions;

    public Location(String name) {
        this.name = name;
        description = getLocationString(name, "description");
        items = getLocationStringArray(name, "items");
        furniture = getLocationStringArray(name, "furniture");
        door = getLocationStringArray(name, "door");
        character = getLocationStringArray(name, "character");
        directions = getLocationStringArray(name, "directions");
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
