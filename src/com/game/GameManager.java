package com.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GameManager {

    static GameClient game;

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

    static void saveGame(){
        try{
            FileOutputStream fos = new FileOutputStream("Key.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.flush();
            oos.close();
            System.out.println("Game Saved!\n");
        } catch (Exception e) {
            System.out.println("Error! Can't save data. \n"
                    + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }
    static void loadGame(){
        try {
            FileInputStream fis = new FileInputStream("Key.sav");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (GameClient) ois.readObject();
            ois.close();
            System.out.println("\n---Game Successfully Loaded!---\n");
        } catch (Exception e) {
            System.out.println("Error! Can't load data. \n");
            System.out.println(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }

    public static String look() {
        System.out.println("What would you like to look at? \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}