package com.example.projet_grandvoyage.Persistence;

import com.example.projet_grandvoyage.AppUtils;
import com.example.projet_grandvoyage.Connection.DBConnection;
import com.example.projet_grandvoyage.User.UserAccount;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {

    public static String update( UserAccount user){

        String result="Data Updated Successfully";
        try{
            DBConnection dbConnection = new DBConnection();
            Connection con = dbConnection.getConnect();
            PreparedStatement ps=con.prepareStatement(
                    "update user set password=?, email=?, phone=?, address=?, gender=?, role=? where uname=?");

            ps.setString(1,user.getPassword());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getAddress());
            ps.setString(5,user.getGender());
            ps.setString(6,user.getRole());
            ps.setString(7,user.getUname());
            ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();
            result="Data Not Updated Successfully";
        }

        return result;
    }

}

