package com.example.projetjava.dao.impl;

import com.example.projetjava.Models.User;
import com.example.projetjava.dao.UserDao;

import java.sql.*;
import java.util.*;


public class UserDaoImpl implements UserDao {
    public static int randomvalu;
    public static int condidat_session;
    public static int recruteur_session;
    private Map<String, String> sessions = new HashMap<>();

    public UserDaoImpl(){

    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();
            statement = connection.createStatement();

            // Requête SQL pour récupérer tous les utilisateurs (candidats et recruteurs)
            String query = "SELECT * FROM condidat UNION SELECT * FROM recruteur";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String motDePasseHash = resultSet.getString("password");
                int randomvalue = resultSet.getInt("randomvalue");

                // Création et ajout de l'objet User à la liste
                users.add(new User(nom, prenom, telephone, email, login, motDePasseHash,randomvalue));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }





    @Override
    public boolean isLoginUnique(String login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour vérifier si un login est unique
            String query = "SELECT * FROM condidat WHERE login=? UNION " +
                    "SELECT * FROM recruteur WHERE login=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, login);

            resultSet = preparedStatement.executeQuery();

            return !resultSet.next(); // Si resultSet.next() est vrai, cela signifie que le login existe déjà

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En cas d'erreur, considérez le login comme non unique par précaution
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int Authentication_user(User user){
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour vérifier si un login et password sont valides

            String query = "SELECT randomvalue FROM condidat WHERE login=? and password=?" ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getMotDePasseHash());

            resultSet = preparedStatement.executeQuery();

            String quer = "SELECT randomvalue FROM recruteur WHERE login=? and password=?" ;
            preparedStatement1 = connection.prepareStatement(quer);
            preparedStatement1.setString(1, user.getLogin());
            preparedStatement1.setString(2, user.getMotDePasseHash());

            resultSet1 = preparedStatement1.executeQuery();

            if(resultSet.next()){
                condidat_session = 1;
                randomvalu = resultSet.getInt("randomvalue");
                return 1;
            } else if (resultSet1.next()) {
                recruteur_session = 1;
                randomvalu = resultSet1.getInt("randomvalue");
                return 2;
            }else {
                return 0;
            }
             // Si resultSet.next() est vrai, cela signifie que les infos sont exacte

        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // En cas d'erreur, considérez le login comme non unique par précaution
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    private String createSession() {
        // Génère un nouvel identifiant de session unique
        String sessionId = UUID.randomUUID().toString();

        // Stocke l'identifiant de session dans la carte des sessions
        sessions.put(sessionId, "User Data");

        return sessionId;
    }

}
