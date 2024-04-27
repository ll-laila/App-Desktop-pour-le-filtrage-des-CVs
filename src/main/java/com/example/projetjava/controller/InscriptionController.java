package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.example.projetjava.Models.User;
import com.example.projetjava.dao.impl.CandidatDaoImpl;
import com.example.projetjava.dao.impl.RecruteurDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static javafx.scene.paint.Color.BLUE;


public class InscriptionController {
    @FXML
    public TextField EntrepriseField;
    @FXML
    public TextField NumPathField;
    private Main app;
    /**
     * on recupere les champs de la view d'authentification
     **/
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button switchButton;
    /**
     * les infos de user
     * **/
    @FXML
    private TextField loginField;
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    @FXML
    private Label a;

    @FXML
    private Label b;

    @FXML
    private Button registerButton;
    @FXML
    private void initialize() {

        EntrepriseField.setVisible(false);
        NumPathField.setVisible(false);
        a.setVisible(false);
        b.setVisible(false);

        errorLabel.setText("");
        comboBox.getItems().addAll("Recruteur", "Condidat");
        comboBox.setOnAction(e ->
        {
            if(comboBox.getValue().equals("Recruteur")){
                EntrepriseField.setVisible(true);
                NumPathField.setVisible(true);
                a.setVisible(true);
                b.setVisible(true);
            }else if(comboBox.getValue().equals("Condidat")){
                EntrepriseField.setVisible(false);
                NumPathField.setVisible(false);
                a.setVisible(false);
                b.setVisible(false);
            }
        });
        switchButton.setOnAction(event ->switchToScene1());
        registerButton.setOnAction(event ->register());
    }

    public void register() {
        /**
        * on récuper les valeurs saisies
        * */
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        /**
         *   on genere une cle pour chaque user pour le identifier 'une facone unique
         * **/
        int randomValue = generateRandomValue();


        if(nom.isEmpty() || password.isEmpty() || phone.isEmpty() || prenom.isEmpty() || email.isEmpty() || confirmPassword.isEmpty() || login.isEmpty()){
            errorLabel.setText("Vous avez un chmaps vide !!!");
        }else {


            if (!password.equals(confirmPassword)) {
                errorLabel.setText("Passwords do not match");
                return;
            }

            /**
             * on test si la lonueur de mot de passe est au moins 8 chars
             * **/

            if(password.length() < 8){
                errorLabel.setText("Password must be at least 8 character !");
                return;
            }

            password = hashSHA256(password);
            User user = new User(nom,prenom,phone,email,login,password,randomValue);

            if (user.isLoginUnique(login)) {
                // Successful registration
                if("Recruteur" == comboBox.getValue()){

                    if(EntrepriseField.getText().isEmpty() || NumPathField.getText().isEmpty()){
                        errorLabel.setText("Vous avez un chmaps vide !!!");
                    }else {
                        //si est un recruteur inserer les infos dans recrureur
                        new RecruteurDaoImpl().addRecruteur(user,EntrepriseField.getText(),NumPathField.getText());
                        errorLabel.setText(" inscrit avec succes Recruteur");
                        errorLabel.setTextFill(BLUE);
                    }


                }else {
                    //si est un condidat inserer les infos dans condidat
                    CandidatDaoImpl condidatDao = new CandidatDaoImpl();
                    condidatDao.addCandidat(user);
                    errorLabel.setText(" inscrit avec succes condidat");
                    errorLabel.setTextFill(BLUE);
                }

            } else {
                // Failed to create user
                // Display an error message
                errorLabel.setText("Failed to create user");
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
     * La fonction pour generer la cle
     * **/
    private int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(1000); // Génère un entier aléatoire entre 0 et 100 inclus
    }

    /**
     * Ces methodes permet de passer d'une scene a une autre
     * ***/
    public void setApp(Main sceneSwitcherApp) {
        this.app = sceneSwitcherApp;
    }

    @FXML
    private void switchToScene1() {
        app.switchToScene1();
    }
}