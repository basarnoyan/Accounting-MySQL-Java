package com.example.accounting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField usernameField;
    @FXML
    private Label errorMsg;
    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button quitButton;
    @FXML
    private PasswordField passwordField;


    public void quitButtonOnAction(ActionEvent e){
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public void setSignInButtonOnAction(ActionEvent e){
        if (usernameField.getText().isBlank()==false && passwordField.getText().isBlank()==false) {
                validateLogin();
        }
        else{
            errorMsg.setText("please enter username and password.");
        }

    }




    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE userName = '" + usernameField.getText() + "' AND password = '" + passwordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    errorMsg.setText("you tried to login");
                }
                else{
                    errorMsg.setText("your username or passwor is incorrec!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void signUpPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}