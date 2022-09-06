package com.game;

import java.io.IOException;

public class Screen {
    public static void ClearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls", "clear").inheritIO().start().waitFor();
    }
}
