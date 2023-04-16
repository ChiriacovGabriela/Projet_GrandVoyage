package com.example.projet_grandvoyage.Cart;

import com.example.projet_grandvoyage.Trip.Trip;

import java.util.ArrayList;
import java.util.List;

    public class Cart  {

        private List<Trip> trips = new ArrayList<>();

        public void addTrip(Trip trip) {
            trips.add(trip);
        }

        public List<Trip> getTrips() {
            return trips;
        }

        public double getTotal() {
            double total = 0;
            for (Trip trip : trips) {
                total += trip.getPrice();
            }
            return total;
        }
    }


