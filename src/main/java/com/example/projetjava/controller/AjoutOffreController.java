package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.dao.impl.OffreDaoImpl;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.sql.Date;

public class AjoutOffreController {
    /**
     * on recupere les champs de la view
     **/
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
    public Button postButton;
    public javafx.scene.control.TextField salaire;

    @FXML
    public Label errorLabel;

    @FXML
    private ImageView Exit;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;

    @FXML
    public TextField intitule;

    @FXML
    public TextField type;
    @FXML
    public DatePicker startdat;
    @FXML
    public DatePicker enddat;
    @FXML
    public TextField vielle;
    @FXML
    public TextField salair;
    @FXML
    public TextArea desc;
    @FXML
    public TextField Criters;
    private Main app;
    public ListView<String> resultList = new ListView<>();
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

        OffresPostules.setOnMouseClicked(evv ->{
            app.switchToOffresPublies();
        });

        deconnecter.setOnMouseClicked(ev->
        {
            app.switchToScene1();
        });
    }

    @FXML
    public void setJobPostingDetails() {

        String intitul = intitule.getText();
        String typ = type.getText();
        String viell = vielle.getText();
        String descr = desc.getText();

        String critere = Criters.getText();

        if(intitul.isEmpty() || typ.isEmpty() || viell.isEmpty() || descr.isEmpty() || salaire.getText().isEmpty() || critere.isEmpty()){
            errorLabel.setText("Champs Vide !!!");
        }else{
            Date datestrt = Date.valueOf(startdat.getValue());
            Date dated = Date.valueOf(enddat.getValue());
            double salair = Double.parseDouble(salaire.getText());
            Offre offre = new Offre(intitul,viell,typ,salair,descr,datestrt,dated,critere);
            OffreDaoImpl ofr = new OffreDaoImpl();
            ofr.addOffre(offre);
        }
    }

    public void setApp(Main app) {
        this.app = app;
    }
}
