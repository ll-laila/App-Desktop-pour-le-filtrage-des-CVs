package com.example.projetjava.Models;

import com.example.projetjava.dao.RecruteurDao;
import javafx.beans.property.SimpleStringProperty;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class Recruteur extends User {

    /**
    *   Attributs
    **/
    private SimpleStringProperty nomEntreprise;
    private SimpleStringProperty adresse;

    private List<Offre> offres; // Liste d'offres associées à ce recruteur
    private RecruteurDao recruteurDAO;
    /**
     * Constructeur
     */
    public Recruteur(){

    }
    public Recruteur(String nom, String prenom, String nomEntreprise, String telephone,String email, String adresse,String login,String motDePasse,int randomvalue) {
        super(nom,prenom,telephone,email,login,motDePasse,randomvalue);
        this.nomEntreprise = new SimpleStringProperty(nomEntreprise);
        this.adresse = new SimpleStringProperty(adresse);
        this.offres = new ArrayList<>();
    }

    /**
     * Getters et Setters
     */
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    public String getNomEntreprise() {
        return nomEntreprise.get();
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise.set(nomEntreprise);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }

    private String hashMotDePasse(String motDePasse) {
        return BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }

    public void ajouterOffre(Offre offre) {
        offres.add(offre);
    }

    public void supprimerOffre(Offre offre) {
        offres.remove(offre);
    }

    public String afficherOffres() {
        StringBuilder result = new StringBuilder();
        result.append("Liste de votre propres offres  ").append(nom.get()).append(" ").append(prenom.get()).append(":\n");

        for (Offre offre : offres) {
            result.append("- ").append(offre.getIntituleOffre()).append("\n");
        }

        return result.toString();
    }

    // Méthode pour obtenir les informations du profil du recruteur
    public String afficherProfil() {
        StringBuilder result = new StringBuilder();
        result.append("Votre profile  ").append(" :\n");
        result.append("Nom: ").append(nom.get()).append("\n");
        result.append("Prénom: ").append(prenom.get()).append("\n");
        result.append("Nom de l'entreprise: ").append(nomEntreprise.get()).append("\n");
        result.append("Téléphone: ").append(telephone.get()).append("\n");
        result.append("Adresse: ").append(adresse.get()).append("\n");
        result.append("Liste des offres publiées:\n");


        result.append(afficherOffres()).append("\n");

        return result.toString();
    }
    // Méthode pour mettre à jour les informations du profil
    public void modifierProfil(String nouveauNom, String nouveauPrenom, String nouveauNomEntreprise,
                               String nouveauTelephone, String nouvelleAdresse) {
        this.nom.set(nouveauNom);
        this.prenom.set(nouveauPrenom);
        this.nomEntreprise.set(nouveauNomEntreprise);
        this.telephone.set(nouveauTelephone);
        this.adresse.set(nouvelleAdresse);
    }

    public void AddRecruteur(User user,String a,String b) {
        recruteurDAO.addRecruteur(user,a,b);
    }
}
