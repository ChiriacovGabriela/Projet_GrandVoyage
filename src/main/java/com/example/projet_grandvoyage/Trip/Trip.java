package com.example.projet_grandvoyage.Trip;

import com.example.projet_grandvoyage.Destination.*;

public class Trip {
    private Destination destination;
    private String description;
    private double price;

    public Trip(Destination destination, String description, double price) {
        this.destination = destination;
        this.description = description;
        this.price = price;
    }
    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
