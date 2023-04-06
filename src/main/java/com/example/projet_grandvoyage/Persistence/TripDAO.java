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


    public String addTrip(Trip trip) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();

        String sql = "insert into grandvoyage.Trip values (?, ?, ?)";

        String result="Data Entered Successfully";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trip.getDestination().getName());
            ps.setString(2, trip.getDescription());
            ps.setDouble(3, trip.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            result="Data Not Entered Successfully";
            e.printStackTrace();
        }
        return result;
    }

    public List<Trip> listTrips() {
        String sql = "SELECT * FROM Trip";
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Trip> trips = new ArrayList<>();
            while (resultSet.next()) {
                Trip trip = new Trip(
                        new Destination(resultSet.getString("destination")),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
                trips.add(trip);
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des offres", e);
        }
    }
}
