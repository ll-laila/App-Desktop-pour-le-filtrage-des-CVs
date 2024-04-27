package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class OfferPostingController {
    /**
     * on recupere les champs de la view
     **/
    @FXML
    public JFXButton ViewProfile = new JFXButton();
    @FXML
    public JFXButton HomePage;

    @FXML
    public JFXButton AddNewCv;
    @FXML
    public JFXButton OffresPostules;
    @FXML
    public VBox LoadCv =new VBox();
    @FXML
    public Button openButton;

    @FXML
    public ImageView ViewCv = new ImageView();
    @FXML
    public Button Ouvrir_CV;

    @FXML
    public JFXButton deconnecter;


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
            app.switchToInfosCondidat();
        });

        AddNewCv.setOnMouseClicked(e -> {
            app.switchToCVLoader();
        });
        OffresPostules.setOnMouseClicked(evv ->{
            app.switchToOffrePosting();
        });
        deconnecter.setOnMouseClicked(ev->
        {
            app.switchToScene1();
        });
        HomePage.setOnMouseClicked(ev -> {
            app.switchToAccuielle();
        });
    }
    /**
     * Fonction pour publier un nouveau offre
     *
     *     @FXML
     *     public TextField intitule;
     *     @FXML
     *     public TextField type;
     *     @FXML
     *     public DatePicker startdat;
     *     @FXML
     *     public DatePicker enddat;
     *     @FXML
     *     public TextField vielle;
     *     @FXML
     *     public TextField salaire;
     *     @FXML
     *     public TextField desc;
     *     @FXML
     *     public TextField Criters;
     *     @FXML
     *     public ListView<String> resultList = new ListView<>();
     *     public void setJobPostingDetails() {
     *         String intitul = intitule.getText();
     *         String typ = type.getText();
     *         String viell = vielle.getText();
     *         String descr = desc.getText();
     *         Date datestrt = Date.valueOf(startdat.getValue());
     *         Date dated = Date.valueOf(enddat.getValue());
     *         double salair = Double.parseDouble(salaire.getText());
     *         String critere = Criters.getText();
     *
     *         Offre offre = new Offre(intitul,viell,typ,salair,descr,datestrt,dated,critere);
     *         OffreDaoImpl ofr = new OffreDaoImpl();
     *         ofr.addOffre(offre);
     *
     *     }
     **/

    /**
     * Ces methodes permet de passer d'une scene a une autre
     * ***/
    public void setApp(Main app) {
        this.app = app;
    }
}
