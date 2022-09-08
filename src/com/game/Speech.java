package com.game;

import java.util.Set;

import static com.game.JSONParser.getCharacters;

public class Speech {
    private final String speech1 = getSpeech1();
    private final String speech2 = getSpeech2();
    private final String speech3 = getSpeech3();
    private final String speech4 = getSpeech4();
    private final String speech5 = getSpeech5();
    private final String speech6 = getSpeech6();

    public String getSpeech1() {
        return speech1;
    }
    public String getSpeech2() {
        return speech2;
    }
    public String getSpeech3() {
        return speech3;
    }
    public String getSpeech4() {
        return speech4;
    }
    public String getSpeech5() {
        return speech5;
    }
    public String getSpeech6() {
        return speech6;
    }

    public static void main(String[] args) {
        Set<String> character = getCharacters();
        System.out.println(character.contains("Cat"));
    }

    @Override
    public String toString() {
        return "Speech{" +
                "name='" + speech1 + '\'' +
                '}';
    }
}