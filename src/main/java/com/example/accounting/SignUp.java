package com.example.accounting;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

import java.io.IOException;
import java.sql.Connection;

public class SignUp {

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private TextField signUpMail;
    @FXML
    private TextField signUpUsername;
    @FXML
    private TextField signUpPassword;
    @FXML
    private Label updateMsg;

    public void signUpButtonAction() throws IOException {

        String verifySignUp = "insert into  useraccounts (mail, userName, password) values ('"+signUpMail.getText()+"', '"+signUpUsername.getText()+"', '"+signUpPassword.getText()+"')";
        int control=0;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verifySignUp);
            signUpMail.clear();
            signUpUsername.clear();
            signUpPassword.clear();
            updateMsg.setText("registeration is successfully complete.");
        }
        catch (Exception e){
            updateMsg.setText("This username or mail already in use");
        }

    }

        public void signUpPageCancel(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}


