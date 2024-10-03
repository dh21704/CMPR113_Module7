package com.mycompany.classexercise7;

import javafx.application.Application;
import javafx.stage.Stage;

public class c1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Santa Ana College");
       
        Label lblUsername = new Label("Username:");
        TextField txtUsername = nwe TextField();
        Label lblPassword = new Label("Password");
        PasswordField txtPassword = new PasswordField();
        Button btnLogin = new Button("Login");
        
        GridPane gridPane = new GridPane();
        
        gridPane.setVgap(10);
        
        gridPane.setHgap(10);
        
        gridPane.add(lblUsername, 0,0);
        gridPane.add(txtUsername, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(txtPassword, 1, 1);
        gridPane.add(btnLogin, 1, 2);
        
        btnLogin.setOnAction(e-> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
        
            if("jsim".equals(username) && "sac".equals(password))
            {
                primaryStage.hide();
                
                openSecondWindow(primaryStage);
            } else{
                showAlert("Invalid Credentials", "wrong username or password");
            }
        });
              
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void openSecondWindow(Stage primaryStage)
    {
        Stage secondStage = new Stage();
        secondStage.setTitle("Student Information");
        
        Label lblName = new Label("Name: ");
        TextField txtName = new TextField();
        Label lblAge = new Label("Age:");
        TextField txtAge = new TextField();
        
        //adding the image
        Image image = new Image("file:sac.png");
        ImageView. imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(200);
        
        Button btnSubmit = new Button("Submit");
        Button btnClose = new Button("Close");
        
        btnSubmit.setOnAction(e -> {
            String name = txtName.getText();
            String age = txtAge.getText();
            showAlert("Submitted Information", "Name: " + name + "\nAge: " + age);
        
        });
        
        btnClose.setOnAction(e -> secondStage.close());
                
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
        
        Scene scene = new Scene(gridPane, 300, 250);
        secondStage.setScene(scene);
        secondStage.show();
        
    }
    
    private void showAlert(String title, String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        
        alert.showAndWait();
    }
}
