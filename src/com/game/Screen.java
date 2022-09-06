package com.game;

public class Screen {
    public static void ClearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
