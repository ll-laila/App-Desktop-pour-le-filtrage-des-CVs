package com.example.projetjava.dao;

import com.example.projetjava.Models.Condidat;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.Models.User;

import java.util.List;

public interface CandidatDao {

    public void addCandidat(User candidat);
    public Condidat getCandidatByLogin(String login);
    public Condidat getCandidatById();
    public Recruteur getRecruteuroffreById();

    Condidat getCandidatByLogin(int r);

    List<String> getAllCandidateurs();

    public List<Condidat> getAllCandidats();

    public void updateCandidat(User candidat);

    public void deleteCandidat(Condidat candidat);

    // Lire toutes les offres pour un candidat donné
    public List<Offre> getOffresForCandidat(int candidatId);

    // Ajouter un candidat à une offre
    void addCandidatToOffre(int candidatId, int offre,List<String> competences,float score);


    // Supprimer une offre / des offres postulées par un candidat
    public void removeCandidatFromOffre(int candidatId, Offre offre);
}

