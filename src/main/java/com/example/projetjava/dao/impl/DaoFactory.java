package com.example.projetjava.dao.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

/*
 * La DAO Factory (DaoFactory.java) permet d'initialiser le DAO en chargeant
 * notamment les drivers nécessaires(ici un driver JDBC MySQL) et se connecte à
 * la base de données. La Factory peut
 *  fournir plusieurs DAO (ici, il n'y en a qu'un seul, UtilisateurDao,
 *    qui correspond à une table de la base).
 *
 */

public class DaoFactory {
    private final String url;
    private final String username;
    private final String password;


    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }



    public static DaoFactory getInstance() {
        try {
            forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {

        }
        return new DaoFactory("jdbc:mariadb://localhost:3306/appdatabase", "root", "");
    }



    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/appdatabase?user=root");
        return con;
    }



}