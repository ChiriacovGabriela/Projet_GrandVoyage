package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.Destination.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DestinationDAO {

    public void addDestination(Destination destination) {
        String sql = "INSERT INTO grandvoyage.Destination VALUES (?)";
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, destination.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'offre", e);
        }
    }
}
