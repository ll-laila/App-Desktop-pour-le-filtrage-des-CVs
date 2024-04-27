package com.example.projetjava.dao.impl;

import com.example.projetjava.Models.Condidat;
import com.example.projetjava.Models.Offre;
import com.example.projetjava.Models.Recruteur;
import com.example.projetjava.dao.OffreDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;


public class OffreDaoImpl implements OffreDao {


    @Override
    public void addOffre(Offre offre) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour ajouter une offre
            String query = "INSERT INTO offre (intitule_p, ville, type, salaire, description_poste, dateLancement, dateExpiration,randomvalue,critères) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, offre.getIntituleOffre());
            preparedStatement.setString(2, offre.getVille());
            preparedStatement.setString(3, offre.getType());
            preparedStatement.setDouble(4, offre.getSalaire());
            preparedStatement.setString(5, offre.getDescription());
            preparedStatement.setDate(6, new Date(offre.getDateLancement().getTime()));
            preparedStatement.setDate(7, new Date(offre.getDateExpiration().getTime()));
            preparedStatement.setInt(8, randomvalu);
            preparedStatement.setString(9,offre.getCriteres());
            preparedStatement.executeUpdate();

            // Récupération de l'ID généré pour l'offre
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idOffre = generatedKeys.getInt(1);
                offre.setIdOffre(idOffre);
            }
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
    public List<String> getOffreById(int offreId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Offre offre = null;

        List<String> wordsToSearch = new ArrayList<>();
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour récupérer une offre par son ID
            String query = "SELECT critères FROM offre WHERE id_offre = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, offreId);

            // Exécution de la requête
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                wordsToSearch.add(resultSet.getString("critères"));
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

        return wordsToSearch;
    }






    @Override
    public Recruteur getRecruteuroffre(int recruteurId) {

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
    public List<Offre> getAllOffres() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Offre> offres = new ArrayList<>();

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();
            statement = connection.createStatement();

            // Requête SQL pour récupérer toutes les offres
            String query = "SELECT * FROM offre";
            resultSet = statement.executeQuery(query);

            // Traitement des résultats
            while (resultSet.next()) {
                Offre offre = new Offre(
                        resultSet.getString("intitule_p"),
                        resultSet.getString("ville"),
                        resultSet.getString("type"),
                        resultSet.getDouble("salaire"),
                        resultSet.getString("description_poste"),
                        resultSet.getDate("dateLancement"),
                        resultSet.getDate("dateExpiration"),
                        resultSet.getString("critères")

                );
                offre.setIdOffre(resultSet.getInt("randomvalue"));
                offres.add(offre);
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

        return offres;
    }



    @Override
    public void updateOffre(Offre offre) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour mettre à jour une offre
            String query = "UPDATE offre SET intitule_p=?, ville=?, type=?, salaire=?, description_poste=?, dateLancement=?, dateExpiration=? WHERE id_offre=?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, offre.getIntituleOffre());
            preparedStatement.setString(2, offre.getVille());
            preparedStatement.setString(3, offre.getType());
            preparedStatement.setDouble(4, offre.getSalaire());
            preparedStatement.setString(5, offre.getDescription());
            preparedStatement.setDate(6, new Date(offre.getDateLancement().getTime()));
            preparedStatement.setDate(7, new Date(offre.getDateExpiration().getTime()));
            preparedStatement.setInt(8, offre.getIdOffre());

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
    public void deleteOffre(int offreId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour supprimer une offre
            String query = "DELETE FROM offre WHERE id_offre=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, offreId);

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
    public List<Condidat> getCandidatsForOffre(int offreId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Condidat> candidats = new ArrayList<>();

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour récupérer les candidats pour une offre donnée
            String query = "SELECT c.* FROM candidat c " +
                    "INNER JOIN candidature ca ON c.id_condidat = ca.id_condidat " +
                    "WHERE ca.id_offre = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, offreId);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Condidat candidat = new Condidat(
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
                candidat.setId(resultSet.getInt("id_condidat"));
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
    public List<Offre> getOffresByVille(String ville) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Offre> offres = new ArrayList<>();

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            // Requête SQL pour récupérer les offres par ville
            String query = "SELECT * FROM offre WHERE ville = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ville);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Offre offre = new Offre(
                        resultSet.getString("intitule_p"),
                        resultSet.getString("ville"),
                        resultSet.getString("type"),
                        resultSet.getDouble("salaire"),
                        resultSet.getString("description_poste"),
                        resultSet.getDate("dateLancement"),
                        resultSet.getDate("dateExpiration"),
                        resultSet.getString("critères")

                );
                offre.setIdOffre(resultSet.getInt("id_offre"));
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


    public static void main(String[] args) {
        OffreDaoImpl o = new OffreDaoImpl();
        List<String> list = new ArrayList<String>();
        list = o.getOffreById(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }



}
