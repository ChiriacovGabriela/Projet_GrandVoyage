package com.example.projet_grandvoyage.Servlets;

import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.Destination.Destination;

import java.sql.Connection;

import com.example.projet_grandvoyage.Persistence.*;
import com.example.projet_grandvoyage.Trip.*;
import com.example.projet_grandvoyage.Destination.*;

public class Main {
    public static void main(String [] args){

        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        DestinationDAO destinationDAO = new DestinationDAO();

        Destination destination = new Destination("France");
        destinationDAO.addDestination(destination);

    }
}
