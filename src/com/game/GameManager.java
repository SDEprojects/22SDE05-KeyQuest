package com.game;

import java.util.Scanner;

public class GameManager {
    public static String start() {
        System.out.println("Would you like to start a game? Enter 'start' to start, 'quit' to exit \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void quit() throws InterruptedException {
        System.out.println("Closing game");
        System.out.println("............");
        Thread.sleep(2);
        System.out.println("Game closed");
    }
}
