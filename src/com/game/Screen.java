package com.game;

import java.io.IOException;

public class Screen {
    public static void ClearScreen() {

       try {
           if(System.getProperty("os.name").contains("Windows")) {
               new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
           } else {
               Runtime.getRuntime().exec("clear");
           }
       } catch (IOException | InterruptedException ignored) {

        }
    }
    public static void DivideScreen() {
        System.out.println("\n=====================================================================================================\n");
    }

}
