package com.game;

import static com.game.JSONParser.getCommands;

public class Command {
    private final String name;
    private final String[] values;

    public Command(String name) {
        this.name = name;
        values = getCommands(name);
    }

    public  String getName() {
        return name;
    }

    public String[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
