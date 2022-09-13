package com.game;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class GameManagerTest {

    private final String OUTPUT_FILE = "output.txt";
    @BeforeEach
    void startGame() throws FileNotFoundException, InterruptedException {
        PrintStream outStream = System.out;
        PrintStream outfile = new PrintStream(new FileOutputStream(OUTPUT_FILE, true));
        System.setOut(outfile);
        GameManager.start();
    }

    @AfterAll
    void cleanup() throws IOException {
        Files.delete(Paths.get(OUTPUT_FILE));
    }

    @Test
    void start() throws IOException, InterruptedException {
        String fileContent = getOutputLogs();
        assertTrue(fileContent.contains("Would you like to start the game"));
        GameManager.quit();
    }

    @Test
    void quit() throws IOException, InterruptedException {
        GameManager.quit();
        String fileContent = getOutputLogs();
        assertTrue(fileContent.contains("Closing game"));
        assertTrue(fileContent.contains("Game closed"));
    }

    @Test
    void confirmQuit() throws IOException {
        GameManager.confirmQuit();
        String fileContent = getOutputLogs();
        assertTrue(fileContent.contains("Confirm exit the game? Enter 'yes' to confirm exit, 'no' to return"));
    }

    @Test
    void look() throws IOException, InterruptedException {
        GameManager.look();
        String fileContent = getOutputLogs();
        assertTrue(fileContent.contains("What would you like to look at?"));
        GameManager.quit();
    }

    private String getOutputLogs() throws IOException {
        return Files.readString(Paths.get(OUTPUT_FILE));
    }
}