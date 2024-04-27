package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.example.projetjava.Models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthController {

    @Getter

    /**
    * on recupere les champs de la view d'authentification
    **/
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabel1;

    @FXML
    private Button loginButton;

    private Main  app;

    @FXML
    private Button switchButton;



    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> login());
        switchButton.setOnAction(event ->switchToScene2());
    }

    public void login(){

        /**
         * On recupere le login et password
         * */

        String username = usernameField.getText();

        String password = passwordField.getText();

        /**
         * hasher le mot de passe
         * **/

        String passwordhash = hashSHA256(password);

        User user = new User(username,passwordhash);

        if(username.isEmpty() || password.isEmpty()){
            if(username.isEmpty()){errorLabel.setText("usrname empty !!!");}else { errorLabel.setText("");}
            if(password.isEmpty()){errorLabel1.setText("password empty !!!");}else { errorLabel1.setText("");}
        }else{
            errorLabel.setText("");
            errorLabel1.setText("");
            if (user.Authentication_user(user) == 1) {
                // Successful authentication en tant que condidat

                switchToAccuielle();
            } else if (user.Authentication_user(user) == 2){
                // Successful authentication en tant que recruteur

                switchToAccuielleRec();
            }else {
                // Invalid credentials
                // Display an error message
                errorLabel.setText("usrname or password invalid");
            }
        }
    }

    /**
     * La fonction de hachage
     * **/
    public static String hashSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Ces methodes permet de passer d'une scene a une autre
     * ***/
    @FXML
    private void switchToScene2() {
        app.switchToScene2();
    }

    @FXML
    private void switchToAccuielle() {
        app.switchToAccuielle();
    }

    @FXML
    private void switchToAccuielleRec(){
        app.switchToAccuielleRec();
    }
    public void setApp(Main app) {
        this.app = app;
    }

}
