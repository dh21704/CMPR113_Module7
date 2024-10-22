/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Danny
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      // Create UI elements
        Label label = new Label("Database Connection");
        Button button = new Button("Connect");

        // Set button action
        button.setOnAction(event -> {
            
            String DB_URL = "jdbc:sqlite:test.db";
            try {
                // Load SQLite JDBC driver
                //Class.forName("org.sqlite.JDBC");

                // Establish connection
                Connection conn = DriverManager.getConnection(DB_URL);

                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM t");

                // Process the results   

                while (rs.next()) {
                    String data = rs.getString("ID");
                    System.out.println(data);
                }

                // Close resources
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        // Create layout and scene
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, button);
        Scene scene = new Scene(layout, 300, 200);

        // Set stage properties and show
        primaryStage.setScene(scene);
        primaryStage.setTitle("Database Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
