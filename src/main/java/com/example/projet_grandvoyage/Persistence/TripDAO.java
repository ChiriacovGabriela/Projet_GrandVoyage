package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.Trip.*;
import com.example.projet_grandvoyage.Destination.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TripDAO implements TripDAOInterface {

    public void addTrip(Trip trip) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();

        String sql = "insert into grandvoyage.trip values (?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trip.getDescription());
            ps.setDouble(2, trip.getPrice());
            ps.setString(3, trip.getDestination().getName());
            ps.setString(4, trip.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection(con);
    }


    public void updateTrip(Trip trip) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();

        String sql = "update grandvoyage.Trip set description=?, price=?, destination=? where name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trip.getDescription());
            ps.setDouble(2, trip.getPrice());
            ps.setString(3, trip.getDestination().getName());
            ps.setString(4, trip.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection(con);
    }
    public void deleteTrip(String tripName) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        String sql = "DELETE FROM grandvoyage.Trip WHERE name=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tripName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection(con);
    }

    public List<Trip> listTrips() {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        String sql = "SELECT * FROM grandvoyage.trip";
        List<Trip> trips = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)){

             ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Trip trip = new Trip(
                            resultSet.getString("name"),
                            new Destination(resultSet.getString("destination")),
                            resultSet.getString("description"),
                            resultSet.getDouble("price"));
                    trips.add(trip);
                }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des offres", e);
        }
        dbConnection.closeConnection(con);
        return trips;
    }
}
