package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.Cart.Cart;
import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.Destination.Destination;
import com.example.projet_grandvoyage.Trip.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartDAO {

    public void addTrip(Trip trip) {

        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        String sql = "insert into grandvoyage.cart values (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trip.getName());
            ps.setDouble(2, trip.getPrice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConnection.closeConnection(con);
    }

    public List<Trip> getTrips() {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        String sql = "SELECT * FROM grandvoyage.cart";
        List<Trip> trips = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                TripDAO tripDAO = new TripDAO();
                List<Trip> tripsList = tripDAO.listTrips();

                for (Trip tripElement : tripsList) {
                    if(tripElement.getName().equals(resultSet.getString("name"))){
                        Trip trip = new Trip(
                            resultSet.getString("name"),
                            new Destination(tripElement.getName()),
                            tripElement.getDescription(),
                            resultSet.getDouble("price"));
                        trips.add(trip);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.closeConnection(con);
        return trips;
    }

}







