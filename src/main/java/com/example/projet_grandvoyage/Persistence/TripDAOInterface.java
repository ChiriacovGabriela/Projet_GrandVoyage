package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.Trip.*;

import java.util.List;

public interface TripDAOInterface {

    void addTrip(Trip trip);
    List<Trip> listTrips();

}
