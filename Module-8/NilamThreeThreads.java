package com.example.javafx;
// Name: Nilam Abdul-Haqq
// Date: 07/21/2025
// Assignment: Three Threads Character Generator
// Purpose: Run 3 threads to generate random letters, digits, and symbols concurrently

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class NilamThreeThreads extends Application {

    private static final int COUNT = 10000;
    private static final char[] SYMBOLS = {'!', '@', '#', '$', '%', '&', '*'};

    private final Random random = new Random();
    private final TextArea textArea = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        textArea.setWrapText(true);

        BorderPane root = new BorderPane(textArea);
        Scene scene = new Scene(root, 700, 400);
        stage.setScene(scene);
        stage.setTitle("Three Threads Output");
        stage.show();

        startThreads(); // Launch all 3 threads
    }

    private void startThreads() {
        // Threads for random letters
        new Thread(() -> {
            for(int i = 0; i < COUNT; i++) {
                char c = (char) ('a' + random.nextInt(26));
                appendToTextArea(c);
            }
        }).start();

        // Thread for random digits
        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char c = (char) ('0' + random.nextInt(10));
                appendToTextArea(c);
            }
        }).start();

        // Thread for random symbols
        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char c = SYMBOLS[random.nextInt(SYMBOLS.length)];
                appendToTextArea(c);
            }
        }).start();
    }

    // Ensure thread-safe JavaFX UI update
    private void appendToTextArea(char c) {
        Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }
}
