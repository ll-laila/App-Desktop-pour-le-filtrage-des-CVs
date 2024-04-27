package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class OffresPubliesController {
    /**
     * on recupere les champs de la view
     **/
    @FXML
    public VBox vbox;
    @FXML
    public VBox vbox1;

    @FXML
    public JFXButton ViewProfile = new JFXButton();
    @FXML
    public JFXButton HomePage;

    @FXML
    public JFXButton AddOffer;

    @FXML
    public JFXButton OffresPostules;

    @FXML
    public JFXButton deconnecter;
    @FXML
    public Label valueLabel;

    @FXML
    public VBox b;

    @FXML
    private ImageView Exit;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;

    private Main app;

    public void initialize() {

        slider.setTranslateX(-176);
        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent ev) -> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });


        ViewProfile.setOnMouseClicked(event -> {
            app.switchToInfosRecruteur();
        });

        AddOffer.setOnMouseClicked(e -> {
            app.switchToAjoutOffre();
        });

        HomePage.setOnMouseClicked(ev -> {
            app.switchToAccuielleRec();
        });

        OffresPostules.setOnMouseClicked(evv -> {
            app.switchToOffresPublies();
        });

        deconnecter.setOnMouseClicked(ev ->
        {
            app.switchToScene1();
        });


        // Créer les éléments du code JavaFX
        HBox nomHBox = createHBox("Nom & Prenom: ", "ouhba youssef");
        HBox phoneHBox = createHBox("Phone :", "0698113157");
        HBox emailHBox = createHBox("Email :", "Youssefouhba@gmail.com");
        HBox prenomHBox = createHBox("CV :", "ouhbavc.pdf");

        nomHBox.setTranslateX(20);
        prenomHBox.setTranslateX(20);
        phoneHBox.setTranslateX(20);
        emailHBox.setTranslateX(20);

        // Créer la structure VBox
        b.getChildren().addAll(nomHBox,  phoneHBox, emailHBox,prenomHBox);
        b.setSpacing(6);


        String[] s = {"Web Developper","Stage"};
        for (String i : s){
            Button addButton = createMenuButton(i);
            addButton.setMaxHeight(100);
            addButton.setMinHeight(40);
            addButton.setMinWidth(200);
            addButton.setMaxWidth(200);
            addButton.setWrapText(true);
            vbox.prefWidthProperty().bind(addButton.widthProperty());
            addButton.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';-fx-border-color: white;-fx-border-width: 0 0 2 0;-fx-background-color: #f1f1f8;-fx-background-radius: 0;-fx-text-fill: #000000;");
            vbox.getChildren().addAll(addButton);
        }

            // Créer le Slider
            Slider slider = new Slider();
            slider.setMin(0);
            slider.setMax(100);
            slider.setValue(50);
            valueLabel.textProperty().bind(Bindings.format("%.0f", slider.valueProperty()));
// Ajouter un ChangeListener à la valeur du Slider
            slider.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    // Exécuter l'action en fonction de la nouvelle valeur du Slider
                    double value = newValue.doubleValue();
                    if (value <= 25) {
                        System.out.println("Valeur inférieure ou égale à 25");
                        // Action correspondante pour une valeur inférieure ou égale à 25
                    } else if (value <= 50) {
                        System.out.println("Valeur inférieure ou égale à 50");
                        // Action correspondante pour une valeur inférieure ou égale à 50
                    } else {
                        System.out.println("Valeur supérieure à 50");
                        // Action correspondante pour une valeur supérieure à 50
                    }
                }
            });
            // Ajouter le Slider à la VBox
            vbox1.getChildren().add(slider);


}

    private HBox createHBox(String labelText, String textValue) {
        Label label = new Label(labelText);
        Text text = new Text(textValue);
        HBox.setMargin(label, new Insets(3, 7, 0, 0));
        HBox hbox = new HBox(label, text);
        hbox.setPrefHeight(19);
        hbox.setPrefWidth(370);
        return hbox;
    }
    private Button createMenuButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(100);
        button.getStyleClass().add("menu-button");
        return button;
    }
    public void setApp(Main app) {
        this.app = app;
    }
}
