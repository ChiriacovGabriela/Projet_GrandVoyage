package com.example.projet_grandvoyage.Connection;

import java.sql.Connection;

public interface DatabaseConnectionInterface {
    public Connection getConnect();
    void closeConnection(Connection con);
}
