package com.example.javafx;
// Name: Nilam Abdul-Haqq
// Date: 07/17/2025
// Assignment Module 7 Programming Assignment
// Purpose: Display 4 circle with external CSS styling (classes and IDs)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle c1 = new Circle(50);
        c1.setId("redcircle");  // ID-based CSS

        Circle c2 = new Circle(50);
        c2.setId("greencircle");  // ID-based CSS

        Circle c3 = new Circle(50);
        c3.getStyleClass().add("plaincircle");  // class-based CSS

        Circle c4 = new Circle(50);
        c4.getStyleClass().add("plaincircle");  // same class
        c4.getStyleClass().add("circleborder");  //additional border

        HBox root = new HBox(20, c1, c2, c3, c4);
        root.getStyleClass().add("border"); // root border as in sample

        Scene scene = new Scene(root, 500, 150);
        scene.getStylesheets().add(getClass().getResource("/com/example/javafx/mystyle.css").toExternalForm());

        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

