package com.example.projetjava.controller;

import com.example.projetjava.Apps.Main;
import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static com.example.projetjava.Traitement.ExtractTextCv.ExtractText;
import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;

public class CVLoaderController {

    @FXML
    public JFXButton ViewProfile;
    @FXML
    public JFXButton HomePage;

    @FXML
    public JFXButton AddNewCv;
    @FXML
    public JFXButton OffresPostules;
    @FXML
    public VBox LoadCv;
    @FXML
    public Button openButton;

    @FXML
    public ImageView ViewCv;
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
    private Window primaryStage;

    @FXML
    private void initialize(){



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

        HomePage.setOnMouseClicked(ev -> {
            app.switchToAccuielle();
        });


        Ouvrir_CV.setOnAction(e -> {
            try {
                File cvFile1 = new File("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu);
                Desktop.getDesktop().open(cvFile1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        OffresPostules.setOnMouseClicked(evv ->{
            app.switchToOffrePosting();
        });
        AddNewCv.setOnMouseClicked(event -> {
            displayPDF("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu);
        });

        deconnecter.setOnMouseClicked(ev->
        {
            app.switchToScene1();
        });

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(60000);
                // Code à exécuter après le délai de 4 secondes
                displayPDF("C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv/"+randomvalu);
                return null;
            }
        };

        new Thread(task).start();


        // Démarre le timer



        openButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choisir un CV");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Fichiers PDF", "*.pdf"),
                    new FileChooser.ExtensionFilter("Tous les fichiers", "*.*")
            );
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                // Define the destination directory to store the uploaded file
                String destinationDirectory = "C:/Users/hp/OneDrive - uca.ac.ma/Bureau/ProjetJava/src/main/java/com/example/projetjava/Traitement/cv";
                // Create the destination directory if it doesn't exist
                File directory = new File(destinationDirectory);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Define the destination file path
                String destinationFilePath = destinationDirectory + File.separator + randomvalu;
                try {
                    // Copy the selected file to the destination directory
                    Path sourcePath = selectedFile.toPath();
                    Path destinationPath = Path.of(destinationFilePath);
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

                    ExtractText();

                    displayPDF(destinationFilePath);

                    System.out.println("File uploaded successfully. Destination: " + destinationFilePath);
                } catch (IOException r) {
                    r.printStackTrace();
                    System.out.println("Error uploading file.");
                }
            } else {
                System.out.println("No file selected.");
            }
        });



    }

    private  void displayPDF(String filePath) {
        try {
            // Chargez le fichier PDF
            PDDocument document = PDDocument.load(new File(filePath));

            // Créez un PDFRenderer pour afficher les pages PDF
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            // Affichez la première page du PDF
            BufferedImage bufferedImage = pdfRenderer.renderImage(0);

            // Convertissez BufferedImage en tableau de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            byte[] imageBytes = baos.toByteArray();
            baos.close();

            // Créez une Image JavaFX à partir des bytes
            InputStream inputStream = new ByteArrayInputStream(imageBytes);
            javafx.scene.image.Image image = new javafx.scene.image.Image(inputStream);

            // Affichez l'image dans votre contrôle d'image JavaFX (ViewCv)
            ViewCv.setImage(image);

            // Fermez le document PDF
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ces methodes permet de passer d'une scene a une autre
     * ***/
    public void setApp(Main app) {
        this.app = app;
    }

    /**
         * on recupere les champs de la view
         **/

}
