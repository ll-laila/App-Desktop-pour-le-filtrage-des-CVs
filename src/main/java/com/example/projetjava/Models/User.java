package com.example.projetjava.Models;

import com.example.projetjava.dao.UserDao;
import com.example.projetjava.dao.impl.UserDaoImpl;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User extends UserDaoImpl {
    /**
     *   Attributs
     **/
    protected SimpleIntegerProperty id;

    protected SimpleStringProperty nom;

    protected SimpleStringProperty prenom;
    protected SimpleStringProperty telephone;
    protected SimpleStringProperty email;
    protected SimpleStringProperty motDePasseHash;

    protected SimpleStringProperty login;
    private UserDao userDao;
    protected int randomvalue;

    /***
     * Constructeurs
     ***/
    public User(String login,String motDePasseHash){
        this.login = new SimpleStringProperty(login);
        this.motDePasseHash = new SimpleStringProperty(motDePasseHash);
    }
    public User(String nom,String prenom,String telephone,String email,String login,String motDePasseHash,int randomvalue){
        this.id = new SimpleIntegerProperty();
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
        this.login = new SimpleStringProperty(login);
        this.motDePasseHash = new SimpleStringProperty(motDePasseHash);
        this.randomvalue = randomvalue;
    }

    public User() {

    }
    /***
     * tester si login est unique
     * ***/
    public boolean checkLogin(){
        return userDao.isLoginUnique(getLogin());
    }
    /***
     * getters and setters
     ***/
    public int getRandomValue() {return this.randomvalue;}
    public void setRandomValue(int randomValue) {this.randomvalue = randomValue;}

    public void setId(int id){  this.id.set(id);}
    public int getId(){  return id.get();}

    public String getNom() {
        return this.nom.get();
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }


    public String getPrenom() {
        return this.prenom.get();
    }
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }


    public String getTelephone() {
        return this.telephone.get();
    }
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public void setMotDePasseHash(String motDePasseHash) {
        this.motDePasseHash.set(motDePasseHash);
    }
    public String getMotDePasseHash() {
        return motDePasseHash.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getEmail() {
        return email.get();
    }

    public void setlogin(String login){
        this.login.set(login);
    }
    public String getLogin() {
        return login.get();
    }
}
