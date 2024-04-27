package com.example.projetjava.Apps;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Searchbaar extends Application {


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

        @Override
        public void start(Stage primaryStage) {
            searchBar = new TextField();
            suggestionScrollPane = new ScrollPane();
            root = new VBox(10);
            root.setPadding(new Insets(10));

            suggestionScrollPane.setContent(root);
            suggestionScrollPane.setVisible(false);

            // Définir la couleur d'arrière-plan pour le VBox
            Color backgroundColor = Color.LIGHTGRAY;
            BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(backgroundFill);
            root.setBackground(background);

            suggestionScrollPane.setStyle("-fx-background-color: transparent; -fx-padding: 0; -fx-border-color: transparent transparent transparent transparent; -fx-border-width: 0 0 1 0;");

            searchBar.setOnKeyReleased(event -> {
                if (event.getCode() == KeyCode.DOWN) {
                    root.requestFocus();
                    if (root.getChildren().size() > 0) {
                        root.getChildren().get(0).requestFocus();
                    }
                } else if (event.getCode() == KeyCode.ENTER) {
                    if (root.getChildren().size() > 0) {
                        searchBar.setText(((SuggestionItem) root.getChildren().get(0)).getText());
                        suggestionScrollPane.setVisible(false);
                    }
                } else {
                    String searchText = searchBar.getText().toLowerCase();
                    root.getChildren().clear();
                    if (!searchText.isEmpty()) {
                        for (String suggestion : suggestions) {
                            if (suggestion.toLowerCase().startsWith(searchText)) {
                                SuggestionItem suggestionItem = new SuggestionItem(suggestion);
                                suggestionItem.setOnMouseClicked(mouseEvent -> {
                                    searchBar.setText(suggestionItem.getText());
                                    suggestionScrollPane.setVisible(false);
                                });
                                root.getChildren().add(suggestionItem);
                            }
                        }
                    }
                    suggestionScrollPane.setVisible(!root.getChildren().isEmpty());
                }
            });

            suggestionScrollPane.setPrefHeight(150);
            suggestionScrollPane.setFitToWidth(true);

            VBox mainLayout = new VBox(10);
            mainLayout.setPadding(new Insets(10));
            mainLayout.getChildren().addAll(searchBar, suggestionScrollPane);

            Scene scene = new Scene(mainLayout, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Search Bar");
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

        public static class SuggestionItem extends HBox {
            private final ImageView logo;
            private final TextField textField;
            public SuggestionItem(String suggestionText) {
                super(10); // Espacement horizontal entre le logo et le champ de texte

                logo = new ImageView(new Image("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/resources/com/example/projetjava/Apps/images/searchoffer.png")); // Remplacez "path/to/your/logo.png" par le chemin d'accès à votre image de logo
                logo.setStyle(" -fx-padding: 0 5 0 0;");
                logo.setFitHeight(14);
                logo.setFitWidth(14);
                textField = new TextField(suggestionText);
                textField.setEditable(false);
                textField.setBackground(Background.EMPTY);


                getChildren().addAll(logo, textField);

                setOnMouseEntered(mouseEvent -> {
                    setStyle("-fx-background-color: white;");
                });

                setOnMouseExited(mouseEvent -> {
                    setStyle("");
                });
            }

            public String getText() {
                return textField.getText();
            }
        }
    public static class SuggestionItem1 extends HBox {

        private final ImageView log;
        private final TextField textField;

        public SuggestionItem1(String suggestionText) {
            super(10); // Espacement horizontal entre le logo et le champ de texte


            log = new  ImageView();
            log.setImage(new Image("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/resources/com/example/projetjava/Apps/images/search.png"));
            log.setStyle(" -fx-padding: 0 5 0 0;");
            log.setFitHeight(14);
            log.setFitWidth(14);


            textField = new TextField(suggestionText);
            textField.setEditable(false);
            textField.setBackground(Background.EMPTY);

            getChildren().addAll(log, textField);

            setOnMouseEntered(mouseEvent -> {
                setStyle("-fx-background-color: white;");
            });

            setOnMouseExited(mouseEvent -> {
                setStyle("");
            });
        }


        public String getText() {
            return textField.getText();
        }
    }
    }