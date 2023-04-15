package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.User.UserAccount;
import com.example.projet_grandvoyage.Connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDao {


    public String insert(UserAccount user) {
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();
        String sql = "insert into grandvoyage.user values(?,?,?,?,?,?,?)";
        String result="Data Entered Successfully";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setNString(4, user.getPhone());
            ps.setNString(5, user.getAddress());
            ps.setNString(6, user.getGender());
            ps.setNString(7, user.getRole());
            ps.executeUpdate();
        } catch ( SQLException e) {
            result="Data Not Entered Successfully";
            e.printStackTrace();
        }
        return result;
    }


}


