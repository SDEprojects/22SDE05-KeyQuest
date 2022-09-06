package com.game;

import java.awt.*;
import java.awt.font.TextLayout;
import java.io.IOException;

public class Screen {
    public static void ClearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls", "clear").inheritIO().start().waitFor();
    }

    public static void DivideScreen() {
        System.out.println("\n=========================================================================================\n");
    }
}
