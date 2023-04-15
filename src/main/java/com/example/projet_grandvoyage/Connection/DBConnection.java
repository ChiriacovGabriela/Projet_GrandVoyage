package com.example.projet_grandvoyage.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements DatabaseConnectionInterface {
    private static String dburl = "jdbc:mysql://localhost:8889/GrandVoyage?autoReconnect=true&useSSL=false";
    private static String dbuname = "root";
    private static String dbpassword = "root";

    @Override
    public Connection getConnect() {
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

    @Override
    public void closeConnection(Connection con) {
        try{
            if(con != null && !con.isClosed()){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
