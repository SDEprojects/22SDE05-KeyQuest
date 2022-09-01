package com.game;

import java.util.Scanner;

public class GameManager {
    public static String start() {
        System.out.println("Would you like to start the game? Enter 'start' to start, 'quit' to exit \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void quit() throws InterruptedException {
        System.out.println("Closing game");
        System.out.println("............");
        Thread.sleep(2);
        System.out.println("Game closed");
    }

    public static String confirmQuit() {
        System.out.println("Confirm exit the game? Enter 'yes' to confirm exit, 'no' to return \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
