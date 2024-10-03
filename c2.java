
package com.mycompany.classexercise7;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class c2 {
    private Connection connect()
    {
        String url = "jdbc:sqlite:users.db";
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected");
            
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    private void createTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
               + " id INTEGER PRIMARY KEY AUTOINCREMENT"
                + " name TEXT NOT NULL"
                + " age INTEGER NOT NULL"
                + ");";
        
        try(Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.execute();
            System.out.println("Table created");
            
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void insertData(String name, int age)
    {
        String sql = "INSERT INTO users(name, age) VALUES(?, ?)";
        
        try(Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Data inserted");
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void start(Stage primaryStage)
    {
        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        
        Label lblAge = new Label("Age:");
        TextField txtAge = new TextField();
        
        Button btnSubmit = new Button("Submit");
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(lblName, txtName, lblAge, txtAge, btnSubmit);
        
        btnSubmit.setOnAction(e -> {
            String name = txtName.getText();
            String ageText = txtAge.getText();
            try
            {
                int age = Integer.parseInt(ageText);
                insertData(name, age);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Data saved successfully!");
                alert.show();
            }catch(NumberFormatException ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a valid number for age");
                alert.show();
            }
        
        });
        
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("User Input App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        createTable();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}