package com.example.projetjava.Models;

import com.example.projetjava.dao.impl.CandidatDaoImpl;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Condidat extends User {

    /**
     *   Attributs
     **/
    private SimpleIntegerProperty id_cv;
    private SimpleStringProperty cheminCV;
    private ObservableList<Offre> listeOffres; // Utilisation d'ObservableList pour les offres

    private CandidatDaoImpl CondidatDAO;


    // Constructeur
    public Condidat(){
        super();
    }
    public Condidat(String nom, String prenom, String telephone, String cheminCV, String email, String login, String motDePasse, int idCV, int randomvalue) {
        super(nom,prenom,telephone,email,login,motDePasse,randomvalue);
        this.cheminCV = new SimpleStringProperty(cheminCV);
        this.listeOffres = FXCollections.observableArrayList();
        this.id_cv = new SimpleIntegerProperty();
    }



    public int getIdCV() {return id_cv.get();}
    public void setIdCV(int id_cv) {
        this.id_cv.set(id_cv);
    }

    public ObservableList<Offre> getListeOffres() {
        return listeOffres;
    }
    public void setListeOffres(ObservableList<Offre> listeOffres) {
        this.listeOffres = listeOffres;
    }



    public void PostulerOffre(Offre offre) {
        listeOffres.add(offre);
    }

    public String afficherOffresPostulees() {
        StringBuilder result = new StringBuilder();
        result.append("Liste des offres auxquelles ").append(prenom.get()).append(" ").append(nom.get()).append(" a postulé :\n");

        for (Offre offre : listeOffres) {
            result.append("- ").append(offre.getIntituleOffre()).append("\n");
        }

        return result.toString();
    }



    // Méthode pour obtenir les informations du profil du candidat
    public String afficherProfil() {
        StringBuilder result = new StringBuilder();
        result.append("Profil du candidat ").append(prenom.get()).append(" ").append(nom.get()).append(" :\n");
        result.append("1. Nom: ").append(nom.get()).append("\n");
        result.append("2. Prénom: ").append(prenom.get()).append("\n");
        result.append("3. Login: ").append(login.get()).append("\n");
        result.append("Liste des offres postulées:\n");

        for (Offre offre : listeOffres) {
            result.append(afficherOffresPostulees()).append("\n");
        }

        return result.toString();
    }

    // Méthode pour mettre à jour les informations du profil
    public void modifierProfil(String nouveauNom, String nouveauPrenom, String nouveauLogin) {
        this.nom.set(nouveauNom);
        this.prenom.set(nouveauPrenom);
        this.login.set(nouveauLogin);
    }






    // Méthode pour récupérer le chemin du CV
    public String getCheminCV() {
        return cheminCV.get();
    }

    // Méthode pour importer le CV
    public void importerCV(String cheminNouveauCV) {
        // Ajouter la logique pour copier le fichier du CV vers le répertoire de stockage du candidat
        // par exemple, vous pourriez utiliser java.nio.file.Files.copy() pour cela
        // Assurez-vous également de mettre à jour le chemin du CV
        // Notez que ceci est un exemple simplifié et peut nécessiter des ajustements en fonction de votre structure d'application
        // Par exemple, vous devriez probablement stocker les CV dans un emplacement spécifique sur le serveur ou dans une base de données
        // Placer les CV dans le répertoire du projet est généralement à des fins de démonstration et pourrait ne pas être sécurisé ou optimal.

        // Exemple :
        // java.nio.file.Files.copy(Paths.get(cheminNouveauCV), Paths.get("chemin/vers/le/repertoire/cv/" + nom.get() + "_" + prenom.get() + "_CV.pdf"), StandardCopyOption.REPLACE_EXISTING);

        // Mettre à jour le chemin du CV
        cheminCV.set("chemin/vers/le/repertoire/cv/" + nom.get() + "_" + prenom.get() + "_CV.pdf");
    }



    public void AddCondidat(User user) {CondidatDAO.addCandidat(user);
    }


}

