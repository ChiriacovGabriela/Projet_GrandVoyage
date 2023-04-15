package com.example.projet_grandvoyage.Persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.User.*;


public class DataDAO {

    public static UserAccount findUser(String userName, String password) throws SQLException {

        UserAccount u = new UserAccount();

        try{
            DBConnection dbConnection = new DBConnection();
            Connection con = dbConnection.getConnect();
            //Connection con = getConnect();
            PreparedStatement ps=con.prepareStatement("SELECT * FROM user WHERE uname=?");
            ps.setString(1,userName);
            ResultSet rs=ps.executeQuery();

            while ( rs.next() ) {

                if (rs.getString(1) != null && rs.getString(2).equals(password)) {
                    u.setUname(rs.getString(1));
                    u.setPassword(rs.getString(2));
                    u.setEmail(rs.getString(3));
                    u.setPhone(rs.getString(4));
                    u.setAddress(rs.getString(5));
                    u.setGender(rs.getString(6));
                    u.setRole(rs.getString(7));
                    return u;
                }
            }
            con.close();}
        catch (Exception ex){
            ex.printStackTrace();
        }

        return u;
    }

}
