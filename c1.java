package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


import java.io.IOException;

public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Santa Ana College");

        //create UI elements for the login window
        Label lblUsername = new Label("Username");
        TextField txtUsername = new TextField();
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        Button btnLogin = new Button("Login");

        GridPane gridPane = new GridPane();

        // Set vertical spacing between rows in the grid
          gridPane.setVgap(10);

        // Set horizontal spacing between columns in the grid
        gridPane.setHgap(10);


        gridPane.add(lblUsername, 0, 0);
        gridPane.add(txtUsername, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(txtPassword, 1, 1);
        gridPane.add(btnLogin, 1, 2);

        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();

            if("jsim".equals(username) && "sac".equals(password))
            {
                //hide the login window after the successfull login
                primaryStage.hide();

                //open second window
                openSecondWindow(primaryStage);
            }else
            {
                showAlert("invalid credentials", "wrong username or password.");
            }
        });

        //set the scene for the login window
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //method to open second window
    private void openSecondWindow(Stage primaryStage)
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("Student Information");

        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        Label lblAge = new Label("Age:");
        TextField txtAge = new TextField();

        //adding an image
        Image image = new Image("file:sac.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(200);

        Button btnSubmit = new Button("Submit");
        Button btnClose = new Button("Close");

        //submit button action to display data in a message box
        btnSubmit.setOnAction(e -> {
            String name = txtName.getText();
            String age = txtAge.getText();
            showAlert("Submitted Information", "Name: " + name + "\nAge: " + age);
                }
                );
        btnClose.setOnAction(e -> secondStage.close());

        //layout for the second window
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(lblName, 0, 0);
        gridPane.add(txtName, 1, 0);
        gridPane.add(lblAge, 0, 1);
        gridPane.add(txtAge, 1, 1);
        gridPane.add(imageView, 1, 2);
        gridPane.add(btnSubmit, 0, 3);
        gridPane.add(btnClose, 1, 3);

        //set the scene for the second window
        Scene scene = new Scene(gridPane, 300, 250);
        secondStage.setScene(scene);
        secondStage.show();
    }

    private void showAlert(String title, String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);

        //display the alert and wait for user acknowledgement
        alert.showAndWait();
    }


}
