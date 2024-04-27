package com.example.projetjava.dao.impl;

import com.example.projetjava.Models.User;
import com.example.projetjava.dao.CvDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.projetjava.dao.impl.UserDaoImpl.randomvalu;

public class CvDaoImpl implements CvDao {

    public static void addCv(String cv) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            connection = daoFactory.getConnection();

            String sql = "INSERT INTO condidat (cv) VALUES (?) WHERE {?} = ?";
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setString(1, "cv");

            statement.setString(2, "randomvalue");
            statement.setInt(3, randomvalu);

            int rowsAffected = statement.executeUpdate();
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



}
