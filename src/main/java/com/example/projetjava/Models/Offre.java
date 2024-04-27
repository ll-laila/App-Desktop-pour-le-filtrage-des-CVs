package com.example.projetjava.Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;

public class Offre {

    // Attributs
    private  SimpleIntegerProperty idOffre;

    private int randomrec;
    private SimpleStringProperty intituleOffre;
    private SimpleStringProperty ville;
    private SimpleStringProperty type;
    private SimpleDoubleProperty salaire;
    private SimpleStringProperty description;
    private Date dateLancement;
    private Date dateExpiration;
    private Recruteur recruteur;

    private String Criteres;
    private ObservableList<Condidat> listeCandidats; // Liste des candidats pour cette offre

    // Constructeur
    public Offre(String intituleOffre, String ville,String type, double salaire, String description,
                 Date dateLancement, Date dateExpiration,String Criteres) {
        this.idOffre = new SimpleIntegerProperty();
        this.intituleOffre = new SimpleStringProperty(intituleOffre);
        this.ville = new SimpleStringProperty(ville);
        this.type = new SimpleStringProperty(type);
        this.salaire = new SimpleDoubleProperty(salaire);
        this.description = new SimpleStringProperty(description);
        this.dateLancement = dateLancement;
        this.dateExpiration = dateExpiration;
        this.listeCandidats = FXCollections.observableArrayList();
        this.Criteres = Criteres;
        this.randomrec = randomvalu;
    }



    // Getters et Setters
    public int getIdOffre() {
        return idOffre.get();
    }

    public void setIdOffre(int idOffre) {
        this.idOffre.set(idOffre);
    }

    public String getIntituleOffre() {
        return this.intituleOffre.get();
    }

    public void setIntituleOffre(String intituleOffre) {
        this.intituleOffre.set(intituleOffre);
    }

    public String getVille() {
        return this.ville.get();
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }

    public String getType() {
        return this.type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }


    public double getSalaire() {
        return this.salaire.get();
    }

    public void setSalaire(double salaire) {
        this.salaire.set(salaire);
    }

    public String getDescription() {
        return this.description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Date getDateLancement() {
        return this.dateLancement;
    }

    public void setDateLancement(Date dateLancement) {
        this.dateLancement = dateLancement;
    }

    public Date getDateExpiration() {
        return this.dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Recruteur getRecruteur() {
        return this.recruteur;
    }

    public void setRecruteur(Recruteur recruteur) {
        this.recruteur = recruteur;
    }

    public String getCriteres(){
        return this.Criteres;
    }

    public void setCriteres(String criteres){
        this.Criteres = criteres;
    }

    public ObservableList<Condidat> getListeCandidats() {
        return this.listeCandidats;
    }

    public void setListeCandidats(ObservableList<Condidat> listeCandidats) {
        this.listeCandidats = listeCandidats;
    }

    public void ajouterCandidat(Condidat candidat) {
        listeCandidats.add(candidat);
    }

    public void supprimerCandidat(Condidat candidat) {
        listeCandidats.remove(candidat);
    }


}

