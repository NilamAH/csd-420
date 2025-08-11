package com.example.javafx;

// Name: Nilam Abdul-Haqq
// Date: 08/10/2025
// Assignment: Fan Information Viewer & Updater
// Purpose: Connect to a MySQL database, view and update records in the 'fans' table via JavaFX UI

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class FanDatabaseApp extends Application {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String DB_USER = "student1";
    private static final String DB_PASSWORD = "pass";

    // UI Components
    private final TextField tfID = new TextField();
    private final TextField tfFirstName = new TextField();
    private final TextField tfLastName = new TextField();
    private final TextField tfFavoriteTeam = new TextField();
    private final Label lblStatus = new Label();

    /**
     * Main entry point for Javafx application
     *
     * @param stage Primary window stage
     */
    @Override
    public void start(Stage stage) {
        // Setup UI layout
        GridPane grid = createFormLayout();

        // Create Buttons
        Button btnDisplay = new Button("Display");
        Button btnUpdate = new Button("Update");

        // Button actions
        btnDisplay.setOnAction(e -> displayFanRecord());
        btnUpdate.setOnAction(e -> updateFanRecord());

        // Add buttons to grid
        grid.add(btnDisplay, 0, 5);
        grid.add(btnUpdate, 1, 5);
        grid.add(lblStatus, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Fan Database Viewer and Updater");
        stage.show();
    }

    /**
     * Creates the form layout with labels and text fields.
     *
     * @return Configured GridPane layout
     */
    private GridPane createFormLayout() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("ID:"), 0, 0);
        grid.add(tfID, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        grid.add(tfFirstName, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(tfLastName, 1, 2);

        grid.add(new Label("Favorite Team:"), 0, 3);
        grid.add(tfFavoriteTeam, 1, 3);

        return grid;
    }

    /**
     * Retrieves and displays a fan record based on the entered ID.
     */
    private void displayFanRecord() {
        String idText = tfID.getText().trim();
        if (idText.isEmpty()) {
            lblStatus.setText("Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

            stmt.setInt(1, Integer.parseInt(idText));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tfFirstName.setText(rs.getString("firstname"));
                tfLastName.setText(rs.getString("lastname"));
                tfFavoriteTeam.setText(rs.getString("favoriteteam"));
                lblStatus.setText("Record displayed successfully.");
            } else {
                lblStatus.setText("No record found with ID " + idText);
                tfFirstName.clear();
                tfLastName.clear();
                tfFavoriteTeam.clear();
            }
        } catch (SQLException e) {
            lblStatus.setText("Error fetching record: " + e.getMessage());
        } catch (NumberFormatException e) {
            lblStatus.setText("Invalid ID format.");
        }
    }

    /**
     * Updates a fan record in the database with the entered values.
     */

    private void updateFanRecord() {
        String idText = tfID.getText().trim();
        if (idText.isEmpty()) {
            lblStatus.setText("Please enter an ID.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {
            stmt.setString(1, tfFirstName.getText().trim());
            stmt.setString(2, tfLastName.getText().trim());
            stmt.setString(3, tfFavoriteTeam.getText().trim());
            stmt.setInt(4, Integer.parseInt(idText));

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                lblStatus.setText("Record updated successfully.");
            } else {
                lblStatus.setText("No record found with ID " + idText);
            }
        } catch (SQLException e) {
            lblStatus.setText("Error updating record: " + e.getMessage());
        } catch (NumberFormatException e) {
            lblStatus.setText("Invalid ID format.");
        }
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args Command-Line arguments (unused)
     */
    public static void main(String[] args) {
        launch(args);
    }
}
