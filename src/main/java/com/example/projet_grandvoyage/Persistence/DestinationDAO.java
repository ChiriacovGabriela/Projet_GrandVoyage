package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.Destination.*;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DestinationDAO {

    public void addDestination(Destination destination) {
        String sql = "INSERT INTO grandvoyage.Destination VALUES (?)";
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, destination.getName());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'offre", e);
        }
    }
    public boolean checkRecordExistence(Destination destination){
        boolean recordExists = false;
        String sql = "SELECT COUNT(*) FROM grandvoyage.Destination where name = ?";
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, destination.getName());
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    int count = rs.getInt(1);
                    if(count > 0){
                        recordExists = true;
                    }
                }
            };
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'offre", e);
        }
        return recordExists;
    }
}
