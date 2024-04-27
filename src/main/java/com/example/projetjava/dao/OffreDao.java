package com.example.projetjava.dao;

import com.example.projetjava.Models.Condidat;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;

import java.util.List;

public interface OffreDao {

    public void addOffre(Offre offre);
    public List<String> getOffreById(int offreId);
    public Recruteur getRecruteuroffre(int recruteurId);
    public List<Offre> getAllOffres();
    public void updateOffre(Offre offre);
    public void deleteOffre(int offreId);

    // Lire tous les candidats pour une offre donnée
    public List<Condidat> getCandidatsForOffre(int offreId);

    // Rechercher les offres par ville
    public List<Offre> getOffresByVille(String ville);



}
