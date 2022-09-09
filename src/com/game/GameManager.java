package com.game;

import java.util.Scanner;

public class GameManager {

    //static Game game;

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

    //Save and Load Work in Progress
    /**
    static void saveGame(){
        try{
            FileOutputStream fos = new FileOutputStream("Key.sav");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(game);
            oos.flush();
            oos.close();
            System.out.println("Game Saved!\n");
            Thread.sleep(50);
        } catch (Exception e) {
            System.out.println("Error! Can't save data. \n"
                    + e.getClass() + ": " + e.getMessage() + "\n");
        }
    }
   static void loadGame(){
        try {
            FileInputStream fis = new FileInputStream("Key.save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            game = (Game) ois.readObject();
            ois.close();
            System.out.println("\n---Game Successfully Loaded!---\n");
        } catch (Exception e) {
            System.out.println("Error! Can't load data. \n");
            System.out.println(e.getClass() + ": " + e.getMessage() + "\n");
        }
    }
    **/
    public static String confirmQuit() {
        System.out.println("Confirm exit the game? Enter 'yes' to confirm exit, 'no' to return \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String look() {
        System.out.println("What would you like to look at? \n>>> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}