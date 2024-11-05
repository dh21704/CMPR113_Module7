/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classexercise6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;  // Use the JavaFX Label here
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;

/**
 *
 * @author Danny
 */
public class c1 extends Application {
   
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    //start method is the entry point of the java FX application
    public void start(Stage primaryStage)
    {
     primaryStage.setTitle("Santa Ana College");
     
     //create UI elements for the login window
     Label lblUsername = new Label("Username:");
     TextField txtUsername = new TextField();
     Label lblPassword = new Label("Password:");
     PasswordField txtPassword = new PasswordField();
     Button btnLogin = new Button("Login");
     
     //layout for the login window
     //create a gridpane layout for arranging elements in 
     GridPane gridPane = new GridPane();
     
     //set vertical spacingf between rows in the grid
     gridPane.setVgap(10);
     //set horizontal spacing between columns in the grid 
     gridPane.setHgap(10);
        
     //add the username label to the first row and first column
     gridPane.add(lblUsername, 0, 0);
     gridPane.add(txtUsername, 1, 0);
     gridPane.add(lblPassword, 0, 1);
     gridPane.add(txtPassword, 1, 1);
     gridPane.add(btnLogin, 1, 2);
   
    
    //login button action
    btnLogin.setOnAction(e -> { 
        
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        if("jsim".equals(username) && "sac".equals(password))
        {
         primaryStage.hide();
         
         //open second window
         openSecondWindow(primaryStage);
        } else
        {
            
         showAlert("Invalid Credentials", "wrong username or password");   
        }
        
    });
    
    //set the scene for the login window 
    Scene scene = new Scene(gridPane, 300, 150);
    primaryStage.setScene(scene);
    primaryStage.show();

    }

    private void openSecondWindow(Stage primaryStage)
    {
     Stage secondStage = new Stage();
     secondStage.setTitle("Student Information");
     
     Label lblName = new Label("Name:");
     TextField txtName = new TextField();
     Label lblAge = new Label("Age:");
     TextField txtAge = new TextField();
     Label lblAddress = new Label("Address:");
     TextField txtAddress = new TextField();
     Label lblCity = new Label("City:");
     TextField txtCity = new TextField();
     Label lblState = new Label("State:");
     TextField txtState = new TextField();
     Label lblZip = new Label("Zip:");
     TextField txtZip = new TextField();
     
     
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
         String address = txtAddress.getText();
         String city = txtCity.getText();
         String state = txtState.getText();
         String zip = txtZip.getText();
         
         //show confirmation alert before submitting
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //confirmation dialog
         alert.setTitle("Confirmation Submission");
         alert.setHeaderText("Please confirm your details");
         alert.setContentText("Name: " + name + " \nAge: " + age + "\nAddress: " + address
         + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip);
         
         //wait for user to click yes/no (OK/Cancel)
         alert.showAndWait().ifPresent(response -> {
          if(response == ButtonType.OK)
          {   
              
           //if user clicks yus 
           showAlert("Submitted Information", "Name: " + name + " \nAge: " + age + "\nAddress: " + address
         + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip);
           
                String filePath = "C:\\Users\\Danny\\OneDrive - Rancho Santiago Community College District\\Desktop\\ClassExercise6Text.txt";           
           try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
           {
            
               writer.write(name);
               writer.newLine();
               writer.write(age);
               writer.newLine();
               writer.write(address);
               writer.newLine();
               writer.write(city);
               writer.newLine();
               writer.write(state);
               writer.newLine();
               writer.write(zip);
               writer.newLine();
               
               showAlert("Information submitted to text document", "");
           }
           catch(IOException ex)
           {
            ex.printStackTrace();   
           }
           
           
          } else
          {
           //user clicked cancel
              showAlert("Submission cancelled", "Your submission has been cancelled");
          }
             
         }
         
         
         );
         
         
         showAlert("Text Document", "Information Submitted");
                 
     });
     
     btnClose.setOnAction(e -> secondStage.close());
     
     //layout for the second window 
     GridPane gridPane = new GridPane();
     gridPane.setVgap(10);
     gridPane.setHgap(10);
     gridPane.add(lblName, 0, 0);
     gridPane.add(txtName, 1, 0);
     gridPane.add(lblAge, 0, 1);
     gridPane.add(txtAge, 1, 1);
     gridPane.add(lblAddress, 0, 2);
     gridPane.add(txtAddress, 1, 2);
     gridPane.add(lblCity, 0, 3);
     gridPane.add(txtCity, 1, 3);
     gridPane.add(lblState, 0, 4);
     gridPane.add(txtState, 1, 4);
     gridPane.add(lblZip, 0, 5);
     gridPane.add(txtZip, 1, 5);
     
     
     gridPane.add(imageView, 1, 6); //display the image
     gridPane.add(btnSubmit, 0, 7);
     gridPane.add(btnClose, 1, 7);
     
     //set the scene for the second window
     Scene scene = new Scene(gridPane, 300, 250);
     secondStage.setScene(scene);
     secondStage.show();     
    }

    //method to show an alert in case of invalid login or submission
    private void showAlert(String title, String message)
    {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle(title);
     alert.setContentText(message);
     
     //display the alert and wait for user acknowledgment
     alert.showAndWait();
    }
}
