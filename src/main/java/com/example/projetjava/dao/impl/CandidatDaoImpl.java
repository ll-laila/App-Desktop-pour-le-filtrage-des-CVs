package com.example.projetjava.dao.impl;

import com.example.projetjava.Models.Condidat;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.Models.User;
import com.example.projetjava.dao.CandidatDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;

public class CandidatDaoImpl implements CandidatDao {

    public CandidatDaoImpl(){}


    @Override
    public void addCandidat(User candidat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Insertion dans la table candidat
            String queryCandidat = "INSERT INTO condidat (nom, prenom,telephone, email, login, password,randomvalue) VALUES (?,?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(queryCandidat, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, candidat.getNom());
            preparedStatement.setString(2, candidat.getPrenom());
            preparedStatement.setString(3, candidat.getTelephone());
            preparedStatement.setString(4, candidat.getEmail());
            preparedStatement.setString(5, candidat.getLogin());
            preparedStatement.setString(6, candidat.getMotDePasseHash());
            preparedStatement.setInt(7,candidat.getRandomValue());
            preparedStatement.executeUpdate();

            // Récupération de l'ID généré
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int candidatId = resultSet.getInt(1);

                // Mise à jour de l'ID du candidat
                candidat.setId(candidatId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermez les ressources dans le bloc finally
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
    public Condidat getCandidatByLogin(String login) {
        return null;
    }


    @Override
    public Condidat getCandidatById() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour vérifier si un login et password sont valides

            String query = "SELECT * FROM condidat WHERE randomvalue=?" ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, randomvalu);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return  new Condidat(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("cv"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("id_cv"),
                        resultSet.getInt("randomvalue")
                );
            }else {
                return null;
            }

            //String a = resultSet.getString("nom");


/*
            if (resultSet.next()) {
                 candidat = new Condidat(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("cv"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("id_cv"),
                        resultSet.getInt("randomvalue")
                );

            }*/
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    public Recruteur getRecruteuroffreById() {
        Recruteur recruteur = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet1 = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour vérifier si un login et password sont valides

            String query = "SELECT * FROM recruteur WHERE randomvalue=?" ;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, randomvalu);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return  new Recruteur(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom_Entr"),
                        resultSet.getString("telephone"),
                        resultSet.getString("email"),
                        resultSet.getString("adresse "),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("randomvalue")
                );
            }else {
                return null;
            }

            //String a = resultSet.getString("nom");


/*
            if (resultSet.next()) {
                 candidat = new Condidat(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("cv"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("id_cv"),
                        resultSet.getInt("randomvalue")
                );

            }*/
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    public Condidat getCandidatByLogin(int r) {
        Condidat candidat = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            String queryRecruteurByLogin = "SELECT * FROM condidat WHERE randomvalue = ?";
            preparedStatement = connection.prepareStatement(queryRecruteurByLogin);
            preparedStatement.setInt(1, r);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return  new Condidat(
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("telephone"),
                        resultSet.getString("cv"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getInt("id_cv"),
                        resultSet.getInt("randomvalue")
                );

                // Mettez à jour l'ID du candidat
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

        return null;
    }





    @Override
    public List<String> getAllCandidateurs() {
        List<String> list = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            String queryCandidats = "SELECT * FROM condidateur WHERE id_offre = ?";
            preparedStatement = connection.prepareStatement(queryCandidats);
            preparedStatement.setInt(1,randomvalu);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(String.valueOf(resultSet.getInt("id_offre")));
                list.add(String.valueOf(resultSet.getInt("id_condidat")));
                list.add(resultSet.getString("compétences"));
                list.add(String.valueOf(resultSet.getFloat("score")));

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

        return list;
    }
    @Override
    public List<Condidat> getAllCandidats() {
        List<Condidat> candidats = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            String queryCandidats = "SELECT * FROM candidat";
            preparedStatement = connection.prepareStatement(queryCandidats);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int candidatId = resultSet.getInt("id_candidat");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String telephone = resultSet.getString("telephone");
                String cv = resultSet.getString("cv");
                String email = resultSet.getString("email");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                int idCV = resultSet.getInt("id_cv");
                int randomvalue = resultSet.getInt("randomvalue");

                Condidat candidat = new Condidat(nom, prenom, telephone,cv, email, login, password, idCV,randomvalue);
                candidat.setId(candidatId);
                candidats.add(candidat);
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

        return candidats;
    }





    @Override
    public void updateCandidat(User candidat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            String queryUpdateCandidat = "UPDATE condidat SET nom = ?, prenom = ?, telephone = ?, email = ?, login = ?, password = ?  WHERE randomvalue = ?";
            preparedStatement = connection.prepareStatement(queryUpdateCandidat);
            preparedStatement.setString(1, candidat.getNom());
            preparedStatement.setString(2, candidat.getPrenom());
            preparedStatement.setString(3, candidat.getTelephone());
            preparedStatement.setString(4, candidat.getEmail());
            preparedStatement.setString(5, candidat.getLogin());
            preparedStatement.setString(6, candidat.getMotDePasseHash());
            preparedStatement.setInt(7,candidat.getRandomValue());
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
    public void deleteCandidat(Condidat candidat) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            int candidatId = candidat.getId();

            // Suppression du recruteur dans la base de données
            String deleteCandidatQuery = "DELETE FROM candidat WHERE id_condidat=?";
            preparedStatement = connection.prepareStatement(deleteCandidatQuery);
            preparedStatement.setInt(1, candidatId);

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
    public List<Offre> getOffresForCandidat(int candidatId) {
        List<Offre> offres = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour obtenir les offres pour un candidat donné
            String query = "SELECT o.* FROM offre o " +
                    "INNER JOIN candidature c ON o.id_offre = c.id_offre " +
                    "WHERE c.id_condidat = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, candidatId);
            resultSet = preparedStatement.executeQuery();

            // Construction des objets Offre à partir des résultats de la requête
            while (resultSet.next()) {
                Recruteur recruteur = null;

                Offre offre = new Offre(
                        resultSet.getString("intitule_p"),
                        resultSet.getString("lieu"),
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





    @Override
    public void addCandidatToOffre(int candidatId,int offreid,List<String> competences,float score) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour ajouter un candidat à une offre
            String query = "INSERT INTO condidateur (id_condidat, id_offre,compétences ,score) VALUES (?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, candidatId);
            preparedStatement.setInt(2, offreid);
            preparedStatement.setString(3, competences.toString());
            preparedStatement.setFloat(4, score);

            // Exécution de la requête
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
    public void removeCandidatFromOffre(int candidatId, Offre offre) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour supprimer la ligne de la table candidature
            String query = "DELETE FROM candidature WHERE id_condidat = ? AND id_offre = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, candidatId);
            preparedStatement.setInt(2, offre.getIdOffre());

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


}
