package com.game;

public class Speech {
    private final String speech1 = getSpeech1();

    public String getSpeech1() {
        return speech1;
    }

    //public static void main(String[] args) {
      //  Set<String> character = getCharacters();
       // System.out.println(character.contains("dog"));
    //}

    @Override
    public String toString() {
        return "Speech{" +
                "name='" + speech1 + '\'' +
                '}';
    }
}