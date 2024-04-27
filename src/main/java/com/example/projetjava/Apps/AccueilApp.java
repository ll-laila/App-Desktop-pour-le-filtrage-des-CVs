package com.example.projetjava.Apps;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class AccueilApp extends Application{

    private final ObservableList<String> suggestions = FXCollections.observableArrayList(
            "Suggestion 1",
            "Suggestion 2",
            "Suggestion 3",
            "Suggestion 4",
            "Suggestion 5"
    );

    private TextField searchBar;
    private ScrollPane suggestionScrollPane;
    private VBox root;
    double x,y = 0;
    private  int condidat_sessio=1;
    @Override
    public void start(Stage primaryStage) throws Exception {


        Parent roott = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccuielleView.fxml")));
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
    public static void main(String[] args) {
        launch(args);
    }
}
