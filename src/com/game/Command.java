package com.game;

import static com.game.JSONParser.getCommands;

public class Command {
    private final String name;
    private final String[] sameCommands;

    public Command(String name) {
        this.name = name;
        sameCommands = getCommands(name);
    }

    public String getName() {
        return name;
    }

    public String[] getSameCommands() {
        return sameCommands;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
