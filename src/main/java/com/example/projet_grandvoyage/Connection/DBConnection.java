package com.example.projet_grandvoyage.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    protected static String dburl = "jdbc:mysql://localhost:8889/GrandVoyage?autoReconnect=true&useSSL=false";
    protected static String dbuname = "root";
    protected static String dbpassword = "root";


    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
            if (con != null) {
                return con;

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
