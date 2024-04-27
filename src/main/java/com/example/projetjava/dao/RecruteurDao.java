package com.example.projetjava.dao;

import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.Models.User;

import java.util.List;

public interface RecruteurDao {
    public void addRecruteur(User recruteur,String a,String b);
    public Recruteur getRecruteurByLogin(String login);
    public Recruteur getRecruteurById(int recruteurId);
    public List<Recruteur> getAllRecruteurs();
    public void updateRecruteur(Recruteur recruteur);
    public void deleteRecruteur(Recruteur recruteur);

    // Lire toutes les offres d'un recruteur par son ID
    public List<Offre> getAllOffresRecr(Recruteur recruteur);

}
