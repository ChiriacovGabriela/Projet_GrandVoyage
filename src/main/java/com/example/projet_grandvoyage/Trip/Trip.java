package com.example.projet_grandvoyage.Trip;

import com.example.projet_grandvoyage.Destination.*;

import java.util.Date;

public class Trip {
    private Destination destination;
    private String description;

    private double price;

    private Date start_date;

    private String name;

    public Trip(String name, Destination destination,  String description, double price) {
        this.name = name;
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
    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date start_date ) {
        this.start_date = start_date;
    }
    public String getName() {
        return name;
    }

    public void setName(String name ) {
        this.name = name;
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
