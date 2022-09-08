package com.game;

import java.util.Arrays;

import static com.game.JSONParser.*;

public class Location {

    private final String name;
    private final String description;
    private final String[] items;
    private final String[] furniture;
    private final String[] door;
    private final String[] character;
    private final String[] directions;

    public Location(String name) {
        this.name = name;
        description = getLocationDescription(name);
        items = getLocationItems(name);
        furniture = getLocationFurniture(name);
        door = getLocationDoor(name);
        character = getLocationCharacter(name);
        directions = getLocationDirections(name);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getItems() {
        return items;
    }

    public String[] getFurniture() {
        return furniture;
    }

    public String[] getDoor() {
        return door;
    }

    public String[] getCharacter() {
        return character;
    }

    public String[] getDirections() {
        return directions;
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
