package com.game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    public void getName() {

    }

    @Test
    void getDescription() {
    }

    @Test
    void getItems() {
        String[] items = {"drumstick", "cucumber"};
        Location loc = new Location("kitchen");
        assertEquals(Arrays.toString(items),Arrays.toString(loc.getItems()));
    }

    @Test
    public void getFurniture() {
        String furniture = "cabinet";
        Location loc = new Location("kitchen");
        assertEquals(furniture,loc.getFurniture()[0]);
      /*  String[] furniture = {"cabinet"};
        Location loc = new Location("kitchen");
        assertEquals(furniture,loc.getFurniture());*/
    }


    @Test
    void getDoor() {
    }

    @Test
    void getCharacter() {
    }

    @Test
    void getDirections() {
    }

    @Test
    void testToString() {
    }

    public static void main(String[] args) {
        Location loc = new Location("kitchen");
        System.out.println(Arrays.toString(loc.getItems()));
    }
}
