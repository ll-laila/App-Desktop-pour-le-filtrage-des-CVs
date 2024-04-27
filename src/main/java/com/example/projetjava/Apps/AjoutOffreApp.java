package com.example.projetjava.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class AjoutOffreApp extends Application {
    double x,y = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent roott = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjoutOffre.fxml")));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.initStyle(StageStyle.UNDECORATED);


        roott.setOnMousePressed(event -> {


            x = event.getSceneX();
            y = event.getSceneY();
        });

        roott.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);

            primaryStage.setY(event.getScreenY() - y);
        });

        Scene scene = new Scene(roott,1000, 900);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
