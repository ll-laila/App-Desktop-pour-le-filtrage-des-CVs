package com.example.projetjava.Apps;

import com.example.projetjava.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Scene scene1;
    private Scene scene2;
    private Scene sceneAccuille;
    private Scene sceneAccuilleRec;
    private Scene sceneInfosCondidat;
    private Scene sceneOffrePosting;
    private Scene sceneCVLoader;
    private Scene sceneInfosRecruteur;
    private Scene sceneAjoutOffre;

    private Scene sceneOffresPublies;

    public double x,y = 0;
    private Scene scenee;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.initStyle(StageStyle.UNDECORATED);


        // Load the scenes from FXML files
        loadScene1(primaryStage);
        loadScene2(primaryStage);
        loadAccuielle(primaryStage);
        loadAccuielleRec(primaryStage);
        loadInfosCondidat(primaryStage);
        loadoOffrePosting(primaryStage);
        loadCVLoader(primaryStage);
        loadAjoutOffre(primaryStage);
        loadOffresPublies(primaryStage);
        loadInfosRecruteur(primaryStage);

        // Set the initial scene
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public void showInfosView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfosCondidatView.fxml"));
            Parent infosView = loader.load();

            // Accéder au contrôleur InfosController
            InfosCondidatController infosController = loader.getController();
            infosController.setMainApp(this); // Passer la référence de MainApp au contrôleur InfosController

            scenee.setRoot(infosView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadScene1(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Auth.fxml"));
            Parent root1 = loader.load();

            root1.setOnMousePressed(event -> {


                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            scene1 = new Scene(root1,1000, 800);
            AuthController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadScene2(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
            Parent root2 = loader.load();

            root2.setOnMousePressed(event -> {


                x = event.getSceneX();
                y = event.getSceneY();
            });

            root2.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            scene2 = new Scene(root2,1000, 800);
            InscriptionController controller2 = loader.getController();
            controller2.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadAccuielle(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccuielleView.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {


                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneAccuille = new Scene(root1,1000, 800);
            AccueilController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAccuielleRec(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilViewRec.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {


                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneAccuilleRec = new Scene(root1,1000, 800);
            AccueilControllerRec controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadInfosCondidat(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfosCondidatView.fxml"));
            Parent root1 = loader.load();

            sceneInfosCondidat = new Scene(root1,1000, 800);
            InfosCondidatController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadoOffrePosting(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OfferPostingView.fxml"));
            Parent root1 = loader.load();
            sceneOffrePosting = new Scene(root1,1000, 800);
            OfferPostingController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCVLoader(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChargerCv.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneCVLoader = new Scene(root1,1000, 800);
            CVLoaderController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadInfosRecruteur(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InfosRecruteurView.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneInfosRecruteur = new Scene(root1,1000, 800);
            InfosRecruteurController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAjoutOffre(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutOffre.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneAjoutOffre = new Scene(root1,1000, 800);
            AjoutOffreController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadOffresPublies(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OffresPubliesView.fxml"));
            Parent root1 = loader.load();
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root1.setOnMouseDragged(event -> {

                primaryStage.setX(event.getScreenX() - x);

                primaryStage.setY(event.getScreenY() - y);
            });
            sceneOffresPublies = new Scene(root1,1000, 800);
            OffresPubliesController controller1 = loader.getController();
            controller1.setApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void switchToScene1() {
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene 1");
    }

    public void switchToScene2() {
        primaryStage.setScene(scene2);
        primaryStage.setTitle("Scene 2");
    }
    public void switchToAccuielle(){
        primaryStage.setScene(sceneAccuille);
        primaryStage.setTitle("Page d'Accuille");
    }

    public void switchToAccuielleRec(){
        primaryStage.setScene(sceneAccuilleRec);
        primaryStage.setTitle("Page d'Accuille Rec");
    }
    public void switchToInfosCondidat(){
        primaryStage.setScene(sceneInfosCondidat);
        primaryStage.setTitle("infos");
    }

    public void switchToCVLoader(){
        primaryStage.setScene(sceneCVLoader);
        primaryStage.setTitle("cv");
    }
    public void switchToOffrePosting(){
        primaryStage.setScene(sceneOffrePosting);
        primaryStage.setTitle("New Offre");
    }
    public void switchToAjoutOffre(){
        primaryStage.setScene(sceneAjoutOffre);
        primaryStage.setTitle("New Offre");
    }

    public void switchToInfosRecruteur(){
        primaryStage.setScene(sceneInfosRecruteur);
        primaryStage.setTitle("New Offre");
    }
    public void switchToOffresPublies(){
        primaryStage.setScene(sceneOffresPublies);
        primaryStage.setTitle("New Offre");
    }
    public static void main(String[] args) {
        launch(args);
    }
}