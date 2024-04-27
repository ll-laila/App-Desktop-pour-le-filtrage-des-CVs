package com.example.projetjava.dao.impl;

import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.Models.User;
import com.example.projetjava.dao.RecruteurDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class RecruteurDaoImpl implements RecruteurDao {
    @Override
    public void addRecruteur(User recruteur,String a,String b) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Insertion dans la table recruteur
            String queryRecruteur = "INSERT INTO recruteur (nom, prenom, tel,email,login, password,randomvalue,nom_Entr ,patent) VALUES (?,?,?, ?, ?, ?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(queryRecruteur, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, recruteur.getNom());
            preparedStatement.setString(2, recruteur.getPrenom());
            preparedStatement.setString(3, recruteur.getTelephone());
            preparedStatement.setString(4, recruteur.getEmail());
            preparedStatement.setString(5, recruteur.getLogin());
            preparedStatement.setString(6, recruteur.getMotDePasseHash());
            preparedStatement.setInt(7,recruteur.getRandomValue());
            preparedStatement.setString(8,a);
            preparedStatement.setString(9,b);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Recruteur getRecruteurByLogin(String login) {
        Recruteur recruteur = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Récupération du recruteur par son login
            String queryRecruteurByLogin = "SELECT * FROM recruteur WHERE login = ?";
            preparedStatement = connection.prepareStatement(queryRecruteurByLogin);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Construisez l'objet Recruteur à partir des résultats de la requête
                recruteur = new Recruteur(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom_Entr"),
                        resultSet.getString("tel"),
                        resultSet.getString("adresse"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("randomvalue")
                );
                // Mettez à jour l'ID du recruteur
                recruteur.setId(resultSet.getInt("id_recr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return recruteur;
    }



    @Override
    public Recruteur getRecruteurById(int recruteurId) {
        Recruteur recruteur = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Récupération du recruteur par son ID
            String queryRecruteurById = "SELECT * FROM recruteur WHERE id_recr = ?";
            preparedStatement = connection.prepareStatement(queryRecruteurById);
            preparedStatement.setInt(1, recruteurId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Construisez l'objet Recruteur à partir des résultats de la requête
                recruteur = new Recruteur(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom_Entr"),
                        resultSet.getString("tel"),
                        resultSet.getString("adresse"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("randomvalue")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return recruteur;
    }




    @Override
    public List<Recruteur> getAllRecruteurs() {
        List<Recruteur> recruteurs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Récupération de tous les recruteurs
            String queryRecruteurs = "SELECT * FROM recruteur";
            preparedStatement = connection.prepareStatement(queryRecruteurs);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String nomEntreprise = resultSet.getString("nom_Entr");
                String telephone = resultSet.getString("tel");
                String adresse = resultSet.getString("adresse");
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                int randomvalue = resultSet.getInt("randomvalue");

                Recruteur recruteur = new Recruteur(nom, prenom, nomEntreprise, telephone, adresse, email,login, password,randomvalue);
                recruteurs.add(recruteur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return recruteurs;
    }





    @Override
    public void updateRecruteur(Recruteur recruteur) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Mise à jour du recruteur dans la base de données
            String updateRecruteurQuery = "UPDATE recruteur SET nom=?, prenom=?, nom_Entr=?, tel=?, adresse=?, email=?, login=?, password=? WHERE randomvalue=?";
            preparedStatement = connection.prepareStatement(updateRecruteurQuery);
            preparedStatement.setString(1, recruteur.getNom());
            preparedStatement.setString(2, recruteur.getPrenom());
            preparedStatement.setString(3, recruteur.getNomEntreprise());
            preparedStatement.setString(4, recruteur.getTelephone());
            preparedStatement.setString(5, recruteur.getAdresse());
            preparedStatement.setString(6, recruteur.getEmail());
            preparedStatement.setString(7, recruteur.getLogin());
            preparedStatement.setString(8, recruteur.getMotDePasseHash());
            preparedStatement.setInt(9, recruteur.getRandomValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }





    @Override
    public void deleteRecruteur(Recruteur recruteur) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            int recruteurId = recruteur.getId();

            // Suppression du recruteur dans la base de données
            String deleteRecruteurQuery = "DELETE FROM recruteur WHERE id_recr=?";
            preparedStatement = connection.prepareStatement(deleteRecruteurQuery);
            preparedStatement.setInt(1, recruteurId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }






    @Override
    public List<Offre> getAllOffresRecr(Recruteur recruteur) {
        List<Offre> offres = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            int recruteurId = recruteur.getId();

            // Récupération de toutes les offres associées à un recruteur
            String queryOffres = "SELECT * FROM offre WHERE id_recruteur = ?";
            preparedStatement = connection.prepareStatement(queryOffres);
            preparedStatement.setInt(1, recruteurId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Offre offre = new Offre(
                        resultSet.getString("intitule_p"),
                        resultSet.getString("ville"),
                        resultSet.getString("type"),
                        resultSet.getInt("salaire"),
                        resultSet.getString("description_poste"),
                        resultSet.getDate("dateLancement"),
                        resultSet.getDate("dateExpiration"),
                        resultSet.getString("critères")

                );
                offres.add(offre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return offres;
    }


}
