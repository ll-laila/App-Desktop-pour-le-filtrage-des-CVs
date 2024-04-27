package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.example.projetjava.Apps.Searchbaar;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.dao.impl.CandidatDaoImpl;
import com.example.projetjava.dao.impl.OffreDaoImpl;
import com.example.projetjava.dao.impl.RecruteurDaoImpl;
import com.jfoenix.controls.JFXButton;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.List;

import static com.example.projetjava.Traitement.Filtraing.CvFiltring;
import static com.example.projetjava.Traitement.Filtraing.score;
import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;
import static javafx.scene.paint.Color.WHITE;

public class AccueilControllerRec{
    /**
     * on recupere les champs de la view
     **/
    @FXML
    public StackPane searchOffer;
    @FXML
    public TextField searchField;
    @FXML
    public StackPane searchvielle;
    @FXML
    public TextField searchFieldv;
    @FXML
    public HBox searchBox;

    @FXML
    public JFXButton ViewProfile = new JFXButton();
    @FXML
    public JFXButton HomePage;
    @FXML
    public VBox sea;
    @FXML
    public VBox Newoffer;
    @FXML
    public JFXButton AddOffer;
    @FXML
    public JFXButton OffresPostules;
    @FXML
    public VBox suggestionContainer;
    @FXML
    public VBox mainLayout;
    @FXML
    public ImageView searchLogo1;
    @FXML
    public ImageView searchLogo;
    @FXML
    public JFXButton deconnecter;
    @FXML
    public ScrollPane scrol;
    @FXML
    public Label offred;

    @FXML
    public Label offre;
    @FXML
    private ImageView Exit;
    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;
    private Main app;
    public static int id_offre;
    CandidatDaoImpl candidatDao = new CandidatDaoImpl();
    private final ObservableList<String> suggestions = offres();
    private final ObservableList<String> suggestionsv = villes();

    @FXML
    private TextField searchBar;
    @FXML
    private ScrollPane suggestionScrollPane;
    @FXML
    private TextField searchBar1;
    @FXML
    private ScrollPane suggestionScrollPane1;
    @FXML
    private VBox suggestionContainer1;
    @FXML
    public ScrollPane searchBox1;
    @FXML
    private VBox listeOfffres;

    public int c = 0;

    @FXML
    public void initialize() {

        sea.setOnMouseEntered(null);


        suggestionScrollPane.toFront();
        suggestionScrollPane1.toFront();
        scrol.toFront();
        searchBox1.toFront();
        offre.toBack();
        offred.toBack();


        OffreDaoImpl offreDao = new OffreDaoImpl();
        List<Offre> listoffres = offreDao.getAllOffres();
        listeOfffres.getChildren().clear();

        // Nombre de HBox à créer dynamiquement
        for (int i = 0; i < listoffres.size(); i++) {


            /**
             * La table a gauche
             * **/

            HBox hbox = new HBox();

            hbox.setPrefSize(350, 150);
            hbox.setStyle("-fx-background-color: white;-fx-border-color: #0094ff;  -fx-border-radius: 6px; -fx-border-width: 1;-fx-padding: 20;");

            VBox labelsContainer = new VBox(); // Conteneur VBox pour les labels
            labelsContainer.setSpacing(10);



            Label intitulPost = new Label(listoffres.get(i).getIntituleOffre());
            Label Entreprise = new Label(listoffres.get(i).getVille());
            Label Viele = new Label(listoffres.get(i).getVille());
            Label typeoffre = new Label(listoffres.get(i).getType());
            Label Description = new Label(listoffres.get(i).getDescription());

            intitulPost.setStyle("--fs-font-size: 20;-fx-font-family: 'Arial Rounded MT Bold'");
            intitulPost.setUnderline(true);

            Entreprise.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
            Viele.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
            typeoffre.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
            Description.setStyle("-fx-font-size: 12;-fx-padding: 0 0 0 15;");


            Description.prefWidth(240);
            Description.prefHeight(300);
            Description.setWrapText(true);

            labelsContainer.getChildren().addAll(intitulPost, Entreprise, Viele, typeoffre, Description);

            hbox.getChildren().add(labelsContainer);
            // Ajoutez ici le contenu spécifique à chaque HBox
            listeOfffres.getChildren().add(hbox);

            /**
             * la table a droite pour les detail de poste
             * **/

            VBox  labelsContainer1 = new VBox();
            labelsContainer1.setSpacing(14);

            // Créez les deux labels
            Label starLabel = new Label("\u27A3");
            Label intituleOffreLabel = new Label(listoffres.get(i).getIntituleOffre());

            starLabel.setStyle("-fx-font-size: 24pt; -fx-text-fill: #006fff;");
            starLabel.setTranslateY(-15);

            intituleOffreLabel.setStyle("-fx-font-size: 15;-fx-font-family: 'Arial Rounded MT Bold';");
            HBox intitulPost1 = new HBox(starLabel, intituleOffreLabel);
            intitulPost1.setSpacing(5); // Espacement entre les labels


            Label Ville = new Label("Vielle ");
            Label Vielev = new Label(listoffres.get(i).getVille().toUpperCase());
            Vielev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
            Vielev.setTextFill(Paint.valueOf("#566674"));
            HBox Viele1 = new HBox(Ville, Vielev);
            Viele1.setSpacing(5);


            Label type = new Label("type-offer ");
            Label typeoffrev = new Label(listoffres.get(i).getType().toUpperCase());
            typeoffrev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
            typeoffrev.setTextFill(Paint.valueOf("#566674"));
            HBox typeoffre1 = new HBox(type, typeoffrev);
            typeoffre1.setSpacing(5);

            Label idoffer = new Label();
            idoffer.setText(String.valueOf(listoffres.get(i).getIdOffre()));
            Label Description1 = new Label(listoffres.get(i).getDescription());
            Description1.setTextFill(Paint.valueOf("#566674"));

            List<Recruteur> recruteurs = new RecruteurDaoImpl().getAllRecruteurs().stream().filter(p->p.getRandomValue()==Integer.parseInt(idoffer.getText())).toList();

            Label Entreprisev;
            HBox  Entreprise1;

            Entreprise = new Label("Entreprise ");
            if (recruteurs.size()!=0){

                Entreprisev = new Label(recruteurs.get(0).getNomEntreprise());

                Entreprisev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                Entreprisev.setTextFill(Paint.valueOf("#566674"));
                Entreprise1 = new HBox(Entreprise, Entreprisev);
                Entreprise1.setSpacing(5);
            }else{
                Entreprisev = new Label(" ");
                Entreprise1 = new HBox(Entreprise, Entreprisev);
                Entreprise1.setSpacing(5);
            }

            intitulPost1.setTranslateY(20);
            intitulPost1.setTranslateX(20);



            Entreprise1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
            Viele1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
            typeoffre1.setStyle("--fs-font-size: 20;-fx-font-family: 'System Bold';-fx-padding: 0 0 0 15;");
            Description1.setStyle("-fx-font-size: 13;-fx-padding: 0 32 0 35;");

            Entreprise1.setTranslateX(25);
            Entreprise1.setTranslateY(5);
            Viele1.setTranslateX(25);
            Viele1.setTranslateY(5);
            typeoffre1.setTranslateX(25);
            typeoffre1.setTranslateY(5);
            Description1.setTranslateY(25);


            Description1.prefWidth(200);
            Description1.setWrapText(true);

            Button btn = new Button("Postuler Maintenat");

            btn.setTranslateX(200);
            btn.setTranslateY(15);
            btn.setStyle("-fx-background-color: #0094ff;-fx-font-family:  'System Bold';-fx-font-size: 15;");
            btn.setTextFill(WHITE);
            Separator separator = new Separator();
            labelsContainer1.getChildren().addAll(btn,intitulPost1, Entreprise1, Viele1, typeoffre1,separator, Description1);

            btn.setOnAction(event -> Postuler());


            hbox.setOnMouseClicked(event -> {
                id_offre = Integer.parseInt(idoffer.getText());
                sea.getChildren().clear();
                sea.getChildren().add(labelsContainer1);
            });
        }

        searchBar1.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                suggestionContainer1.requestFocus();
                if (suggestionContainer1.getChildren().size() > 0) {
                    suggestionContainer1.getChildren().get(0).requestFocus();
                }
            } else if (event.getCode() == KeyCode.ENTER) {
                if (suggestionContainer1.getChildren().size() > 0) {
                    searchBar1.setText(((Searchbaar.SuggestionItem1) suggestionContainer1.getChildren().get(0)).getText());
                    suggestionScrollPane1.setVisible(false);
                }
            } else {
                String searchText = searchBar1.getText().toLowerCase();
                suggestionContainer1.getChildren().clear();
                if (!searchText.isEmpty()) {
                    scrol.toBack();
                    searchBox1.toBack();
                    for (String suggestion : suggestionsv) {
                        if (suggestion.toLowerCase().startsWith(searchText)) {
                            Searchbaar.SuggestionItem1 suggestionItem1 = new Searchbaar.SuggestionItem1(suggestion);
                            suggestionItem1.setOnMouseClicked(mouseEvent -> {
                                searchBar1.setText(suggestionItem1.getText());

                                scrol.toFront();
                                searchBox1.toFront();

                                for (int i = 0; i < listoffres.size(); i++) {
                                    HBox hbox = new HBox();

                                    hbox.setPrefSize(350, 150);
                                    hbox.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 6px; -fx-border-width: 1;-fx-padding: 20;");

                                    VBox labelsContainer = new VBox(); // Conteneur VBox pour les labels

                                    labelsContainer.setSpacing(10);

                                    Label intitulPost = new Label(listoffres.get(i).getIntituleOffre());
                                    Label Entreprise = new Label(listoffres.get(i).getVille());
                                    Label Viele = new Label(listoffres.get(i).getVille());
                                    Label typeoffre = new Label(listoffres.get(i).getType());
                                    Label Description = new Label(listoffres.get(i).getDescription());

                                    intitulPost.setStyle("--fs-font-size: 20;-fx-font-family: 'Arial Rounded MT Bold'");
                                    intitulPost.setUnderline(true);

                                    Entreprise.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Viele.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    typeoffre.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Description.setStyle("-fx-font-size: 14;-fx-padding: 0 0 0 15;");

                                    Description.prefWidth(280);
                                    Description.prefHeight(300);
                                    Description.setWrapText(true);

                                    VBox  labelsContainer1 = new VBox();

                                    labelsContainer1.setSpacing(10);
                                    // Créez les deux labels
                                    Label starLabel = new Label("\u27A3");
                                    Label intituleOffreLabel = new Label(listoffres.get(i).getIntituleOffre());

                                    starLabel.setStyle("-fx-font-size: 24pt; -fx-text-fill: #006fff;");
                                    starLabel.setTranslateY(-15);

                                    intituleOffreLabel.setStyle("-fx-font-size: 15;-fx-font-family: 'Arial Rounded MT Bold';");
                                    HBox intitulPost1 = new HBox(starLabel, intituleOffreLabel);
                                    intitulPost1.setSpacing(5); // Espacement entre les labels


                                    Label Ville = new Label("Vielle ");
                                    Label Vielev = new Label(listoffres.get(i).getVille().toUpperCase());
                                    Vielev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                    Vielev.setTextFill(Paint.valueOf("#566674"));
                                    HBox Viele1 = new HBox(Ville, Vielev);
                                    Viele1.setSpacing(5);


                                    Label type = new Label("type-offer ");
                                    Label typeoffrev = new Label(listoffres.get(i).getType().toUpperCase());
                                    typeoffrev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                    typeoffrev.setTextFill(Paint.valueOf("#566674"));
                                    HBox typeoffre1 = new HBox(type, typeoffrev);
                                    typeoffre1.setSpacing(5);

                                    Label idoffer = new Label();
                                    idoffer.setText(String.valueOf(listoffres.get(i).getIdOffre()));
                                    Label Description1 = new Label(listoffres.get(i).getDescription());
                                    Description1.setTextFill(Paint.valueOf("#566674"));

                                    List<Recruteur> recruteurs = new RecruteurDaoImpl().getAllRecruteurs().stream().filter(p->p.getRandomValue()==Integer.parseInt(idoffer.getText())).toList();

                                    Label Entreprisev;
                                    HBox  Entreprise1;

                                    Label Entreprisee = new Label("Entreprise ");
                                    if (recruteurs.size()!=0){

                                        Entreprisev = new Label(recruteurs.get(0).getNomEntreprise());

                                        Entreprisev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                        Entreprisev.setTextFill(Paint.valueOf("#566674"));
                                        Entreprise1 = new HBox(Entreprisee, Entreprisev);
                                        Entreprise1.setSpacing(5);
                                    }else{
                                        Entreprisev = new Label(" ");
                                        Entreprise1 = new HBox(Entreprisee, Entreprisev);
                                        Entreprise1.setSpacing(5);
                                    }

                                    intitulPost1.setTranslateY(20);
                                    intitulPost1.setTranslateX(20);



                                    Entreprise1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Viele1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    typeoffre1.setStyle("--fs-font-size: 20;-fx-font-family: 'System Bold';-fx-padding: 0 0 0 15;");
                                    Description1.setStyle("-fx-font-size: 13;-fx-padding: 0 32 0 35;");

                                    Entreprise1.setTranslateX(25);
                                    Entreprise1.setTranslateY(5);
                                    Viele1.setTranslateX(25);
                                    Viele1.setTranslateY(5);
                                    typeoffre1.setTranslateX(25);
                                    typeoffre1.setTranslateY(5);
                                    Description1.setTranslateY(25);


                                    Description1.prefWidth(200);
                                    Description1.setWrapText(true);

                                    Button btn1 = new Button("Postuler Maintenat");

                                    btn1.setTranslateX(200);
                                    btn1.setTranslateY(15);
                                    btn1.setStyle("-fx-background-color: #0094ff;-fx-font-family:  'System Bold';-fx-font-size: 15;");
                                    btn1.setTextFill(WHITE);
                                    Separator separator = new Separator();

                                    hbox.setOnMouseClicked(evnt -> {

                                        id_offre = Integer.parseInt(idoffer.getText());
                                        sea.getChildren().clear();
                                        sea.getChildren().add(labelsContainer1);
                                    });

                                    if (listoffres.get(i).getVille().equals(searchBar1.getText()) && searchBar.getText().equals(listoffres.get(i).getIntituleOffre())) {
                                        VBox contentContainer = (VBox) searchBox1.getContent();
                                        contentContainer.getChildren().clear();
                                        labelsContainer.getChildren().addAll(intitulPost, Entreprise, Viele, typeoffre, Description);

                                        hbox.getChildren().add(labelsContainer);
                                        // Ajoutez ici le contenu spécifique à chaque HBox

                                        listeOfffres.getChildren().add(hbox);
                                        labelsContainer1.getChildren().addAll(btn1,intitulPost1, Entreprise1, Viele1, typeoffre1,separator, Description1);
                                        btn1.setOnAction((ActionEvent e) -> Postuler());

                                    }

                                }
                                suggestionScrollPane1.setVisible(false);
                            });
                            suggestionContainer1.getChildren().add(suggestionItem1);

                        }
                    }

                }else {
                }
                suggestionScrollPane1.setVisible(!suggestionContainer1.getChildren().isEmpty());
            }

        });
        suggestionContainer = new VBox(10);
        suggestionContainer.setPadding(new Insets(10));

        suggestionScrollPane.setContent(suggestionContainer);
        suggestionScrollPane.setVisible(false);

        // Définir la couleur d'arrière-plan pour le VBox
        Color backgroundColor = WHITE;
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        suggestionContainer.setBackground(background);

        suggestionScrollPane.setStyle("-fx-background-color: white; -fx-padding: 0;-fx-border-radius: 5; -fx-border-color: transparent  transparent #0094ff #0094ff; -fx-border-width: 0 0 3 2;");

        searchBar.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.DOWN) {
                suggestionContainer.requestFocus();
                if (suggestionContainer.getChildren().size() > 0) {
                    suggestionContainer.getChildren().get(0).requestFocus();
                }
            } else if (event.getCode() == KeyCode.ENTER) {
                if (suggestionContainer.getChildren().size() > 0) {
                    searchBar.setText(((Searchbaar.SuggestionItem) suggestionContainer.getChildren().get(0)).getText());
                    suggestionScrollPane.setVisible(false);
                }
            } else {
                String searchText = searchBar.getText().toLowerCase();
                suggestionContainer.getChildren().clear();
                if (!searchText.isEmpty()) {
                    scrol.toBack();
                    searchBox1.toBack();
                    for (String suggestion : suggestions) {
                        if (suggestion.toLowerCase().startsWith(searchText)) {
                            Searchbaar.SuggestionItem suggestionItem = new Searchbaar.SuggestionItem(suggestion);
                            suggestionItem.setOnMouseClicked(mouseEvent -> {
                                scrol.toFront();
                                searchBox1.toFront();
                                searchBar.setText(suggestionItem.getText());

                                for (int i = 0; i < listoffres.size(); i++) {
                                    HBox hbox = new HBox();

                                    hbox.setPrefSize(350, 150);
                                    hbox.setStyle("-fx-background-color: white;-fx-border-color: #0094ff; -fx-border-radius: 6px; -fx-border-width: 1;-fx-padding: 20;");

                                    VBox labelsContainer = new VBox(); // Conteneur VBox pour les labels
                                    labelsContainer.setSpacing(10);


                                    Label intitulPost = new Label(listoffres.get(i).getIntituleOffre());
                                    Label Entreprise = new Label(listoffres.get(i).getVille());
                                    Label Viele = new Label(listoffres.get(i).getVille());
                                    Label typeoffre = new Label(listoffres.get(i).getType());
                                    Label Description = new Label(listoffres.get(i).getDescription());

                                    intitulPost.setStyle("--fs-font-size: 20;-fx-font-family: 'Arial Rounded MT Bold'");
                                    intitulPost.setUnderline(true);

                                    Entreprise.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Viele.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    typeoffre.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Description.setStyle("-fx-font-size: 12;-fx-padding: 0 0 0 15;");


                                    Description.prefWidth(240);
                                    Description.prefHeight(300);
                                    Description.setWrapText(true);

                                    /**
                                     * la table a droite pour les detail de poste
                                     * **/
                                    VBox  labelsContainer1 = new VBox();

                                    labelsContainer1.setSpacing(10);

                                    // Créez les deux labels
                                    Label starLabel = new Label("\u27A3");
                                    Label intituleOffreLabel = new Label(listoffres.get(i).getIntituleOffre());

                                    starLabel.setStyle("-fx-font-size: 24pt; -fx-text-fill: #006fff;");
                                    starLabel.setTranslateY(-15);

                                    intituleOffreLabel.setStyle("-fx-font-size: 15;-fx-font-family: 'Arial Rounded MT Bold';");
                                    HBox intitulPost1 = new HBox(starLabel, intituleOffreLabel);
                                    intitulPost1.setSpacing(5); // Espacement entre les labels


                                    Label Ville = new Label("Vielle ");
                                    Label Vielev = new Label(listoffres.get(i).getVille().toUpperCase());
                                    Vielev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                    Vielev.setTextFill(Paint.valueOf("#566674"));
                                    HBox Viele1 = new HBox(Ville, Vielev);
                                    Viele1.setSpacing(5);


                                    Label type = new Label("type-offer ");
                                    Label typeoffrev = new Label(listoffres.get(i).getType().toUpperCase());
                                    typeoffrev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                    typeoffrev.setTextFill(Paint.valueOf("#566674"));
                                    HBox typeoffre1 = new HBox(type, typeoffrev);
                                    typeoffre1.setSpacing(5);

                                    Label idoffer = new Label();
                                    idoffer.setText(String.valueOf(listoffres.get(i).getIdOffre()));
                                    Label Description1 = new Label(listoffres.get(i).getDescription());
                                    Description1.setTextFill(Paint.valueOf("#566674"));

                                    List<Recruteur> recruteurs = new RecruteurDaoImpl().getAllRecruteurs().stream().filter(p->p.getRandomValue()==Integer.parseInt(idoffer.getText())).toList();

                                    Label Entreprisev;
                                    HBox  Entreprise1;

                                    Label Entreprisee = new Label("Entreprise ");
                                    if (recruteurs.size()!=0){

                                        Entreprisev = new Label(recruteurs.get(0).getNomEntreprise());

                                        Entreprisev.setStyle("-fx-font-size: 12;-fx-font-family: 'Arial Rounded MT Bold';");
                                        Entreprisev.setTextFill(Paint.valueOf("#566674"));
                                        Entreprise1 = new HBox(Entreprisee, Entreprisev);
                                        Entreprise1.setSpacing(5);
                                    }else{
                                        Entreprisev = new Label(" ");
                                        Entreprise1 = new HBox(Entreprisee, Entreprisev);
                                        Entreprise1.setSpacing(5);
                                    }

                                    intitulPost1.setTranslateY(20);
                                    intitulPost1.setTranslateX(20);



                                    Entreprise1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    Viele1.setStyle("--code-font-size: 60;-fx-padding: 0 0 0 15;");
                                    typeoffre1.setStyle("--fs-font-size: 20;-fx-font-family: 'System Bold';-fx-padding: 0 0 0 15;");
                                    Description1.setStyle("-fx-font-size: 13;-fx-padding: 0 32 0 35;");

                                    Entreprise1.setTranslateX(25);
                                    Entreprise1.setTranslateY(5);
                                    Viele1.setTranslateX(25);
                                    Viele1.setTranslateY(5);
                                    typeoffre1.setTranslateX(25);
                                    typeoffre1.setTranslateY(5);
                                    Description1.setTranslateY(25);


                                    Description1.prefWidth(200);
                                    Description1.setWrapText(true);

                                    Button btn2 = new Button("Postuler Maintenat");


                                    btn2.setTranslateX(200);
                                    btn2.setTranslateY(15);
                                    btn2.setStyle("-fx-background-color: #0094ff;-fx-font-family:  'System Bold';-fx-font-size: 15;");
                                    btn2.setTextFill(WHITE);
                                    Separator separator = new Separator();

                                    hbox.setOnMouseClicked(even -> {
                                        id_offre = Integer.parseInt(idoffer.getText());
                                        sea.getChildren().clear();
                                        sea.getChildren().add(labelsContainer1);
                                    });

                                    if (listoffres.get(i).getIntituleOffre().equals(searchBar.getText()) && listoffres.get(i).getVille().equals(searchBar1.getText())){
                                        VBox contentContainer = (VBox) searchBox1.getContent();
                                        contentContainer.getChildren().clear();
                                        labelsContainer.getChildren().addAll(intitulPost, Entreprise, Viele, typeoffre, Description);
                                        hbox.getChildren().add(labelsContainer);
                                        // Ajoutez ici le contenu spécifique à chaque HBox
                                        listeOfffres.getChildren().add(hbox);
                                        labelsContainer1.getChildren().addAll(btn2,intitulPost1, Entreprise1, Viele1, typeoffre1,separator, Description1);
                                        btn2.setOnAction((ActionEvent e) -> Postuler());
                                    }
                                }
                                suggestionScrollPane.setVisible(false);

                            });
                            suggestionContainer.getChildren().add(suggestionItem);

                        }
                    }
                    suggestionScrollPane.toFront();
                    suggestionScrollPane1.toFront();
                }else {

                }
                suggestionScrollPane.setVisible(!suggestionContainer.getChildren().isEmpty());
            }
        });

        suggestionContainer1 = new VBox(10);
        suggestionContainer1.setPadding(new Insets(10));

        suggestionScrollPane1.setContent(suggestionContainer1);
        suggestionScrollPane1.setVisible(false);

        suggestionContainer1.setBackground(background);

        suggestionScrollPane1.setStyle("-fx-background-color: white; -fx-padding: 0;-fx-border-radius: 5;-fx-border-color: transparent  transparent #0094ff #0094ff; -fx-border-width: 0 0 3 2;");


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






    public  ObservableList<String> offres() {
        OffreDaoImpl offre = new OffreDaoImpl();
        List<Offre> listOffres = offre.getAllOffres();
        ObservableList<String> resultso = FXCollections.observableArrayList();
        for (int i = 0; i < listOffres.size(); i++) {
            resultso.add(listOffres.get(i).getIntituleOffre());
        }

        return resultso;
    }
    public  ObservableList<String> villes() {
        OffreDaoImpl offre = new OffreDaoImpl();
        List<Offre> listOffres = offre.getAllOffres();
        ObservableList<String> resultsv = FXCollections.observableArrayList();
        for (int i = 0; i < listOffres.size(); i++) {

            resultsv.add(listOffres.get(i).getVille());

        }

        return resultsv;
    }
    /**
     * Infos sur chaque offre
     * **/
    public void infosOffre(String intitul,String vil,ObservableList<String> items){
        OffreDaoImpl offre = new OffreDaoImpl();
        List<Offre> listOffres = offre.getAllOffres();
        items.clear();
        // Gérer l'action du clic sur le lien ici
        for (int j = 0; j < listOffres.size(); j++){
            if(intitul.equals(listOffres.get(j).getIntituleOffre()) && listOffres.get(j).getVille().equals(vil)){
                items.addAll(listOffres.get(j).getIntituleOffre());
                items.addAll(listOffres.get(j).getVille());
                items.addAll(listOffres.get(j).getDescription());
                items.addAll(String.valueOf(listOffres.get(j).getSalaire()));
            }

        }

    }

    /**
     * Fonctions de recherche par vielle
     * **/

    public  String[] sendGetRequestv(String query) {
        OffreDaoImpl offre = new OffreDaoImpl();
        List<Offre> listOffres = offre.getAllOffres();

        ObservableList<String> resultsv = FXCollections.observableArrayList();
        ObservableList<String> resultso = FXCollections.observableArrayList();
        ObservableList<String> results = FXCollections.observableArrayList();

        for (int i = 0; i < listOffres.size(); i++) {
            if (listOffres.get(i).getVille().contains(query)) {
                resultsv.add(listOffres.get(i).getVille());
                resultso.add(listOffres.get(i).getIntituleOffre());
            }
        }
        results.addAll(resultsv);
        results.addAll(resultso);

        return results.toArray(new String[0]);
    }
    /**
     * Fonctions de recherche par offre
     * **/
    public static   String[] sendGetRequesto(String query) {
        OffreDaoImpl offre = new OffreDaoImpl();
        List<Offre> listOffres = offre.getAllOffres();

        ObservableList<String> resultsv = FXCollections.observableArrayList();
        ObservableList<String> resultso = FXCollections.observableArrayList();
        ObservableList<String> results = FXCollections.observableArrayList();

        for (int i = 0; i < listOffres.size(); i++) {
            if (listOffres.get(i).getIntituleOffre().contains(query)) {
                resultsv.add(listOffres.get(i).getVille());
                resultso.add(listOffres.get(i).getIntituleOffre());
            }
        }
        results.addAll(resultsv);
        results.addAll(resultso);

        return results.toArray(new String[0]);
    }
    /**
     * Fonction pour postuler a un offre
     * **/
    public void Postuler(){
        try {
            if(score()==1 && CvFiltring().size()!=0){

                VBox content = new VBox();
                //content.prefWidth(10);
                //content.setLayoutX(500);
                //content.setLayoutY(70);

                Label label = new Label("Votre profile ne correspond pas aux criters demandes dans cette offre!!!");
                label.setStyle("-fx-background-color: rgba(0,111,255,0.74);");


                content.getChildren().add(label);

                Scene scene = new Scene(content);

                Stage dialogStage = new Stage(StageStyle.UNDECORATED);
                dialogStage.setScene(scene);
                // Définir la position de la boîte de dialogue
                double x = 600; // Coordonnée X
                double y = 240; // Coordonnée Y
                dialogStage.setX(x);
                dialogStage.setY(y);

                dialogStage.show();

                // Fermer la boîte de dialogue après une durée donnée
                PauseTransition delay = new PauseTransition(Duration.seconds(5));
                delay.setOnFinished(event -> dialogStage.close());
                delay.play();
            }else{
                candidatDao.addCandidatToOffre(randomvalu,id_offre,CvFiltring(),score());
            }
        }catch (Exception e){

            VBox content = new VBox();
            content.prefWidth(10);

            Label label = new Label("Charger votre cv !!!");
            label.setStyle("-fx-border-color: white;-fx-border-radius: 3;-fx-color: blue;-fx-background-color: orange;-fx-border-width: 2;");

            content.getChildren().add(label);

            Scene scene = new Scene(content);

            Stage dialogStage = new Stage(StageStyle.UNDECORATED);
            dialogStage.setScene(scene);
            // Définir la position de la boîte de dialogue
            double x = 800; // Coordonnée X
            double y = 210; // Coordonnée Y
            dialogStage.setX(x);
            dialogStage.setY(y);

            dialogStage.show();

            // Fermer la boîte de dialogue après une durée donnée
            PauseTransition delay = new PauseTransition(Duration.seconds(5));
            delay.setOnFinished(event -> dialogStage.close());
            delay.play();
        }

    }

    /**
     * Fonction pour aller vers son profile
     * **/

    public void setApp(Main app) {
        this.app = app;
    }

}


