package com.example.projet_grandvoyage.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;


import com.example.projet_grandvoyage.*;

public class DataDAO {

    private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

    /*static {
        initUsers();
    }

    /*private static void initUsers() {

        // This user has a role as EMPLOYEE.
        UserAccount emp = new UserAccount("employee1", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_CLIENT);

        // This user has 2 roles EMPLOYEE and MANAGER.
        UserAccount mng = new UserAccount("manager1", "123", UserAccount.GENDER_MALE, //
                SecurityConfig.ROLE_CLIENT, SecurityConfig.ROLE_MANAGER);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
    }*/

    // Find a User by userName and password.
    protected static String jbdcURL = "jdbc:mysql://localhost:8889/GrandVoyage?autoReconnect=true&useSSL=false";
    protected static String userName = "root";
    protected static String userPassword = "root";
    public static Connection getConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jbdcURL, userName, userPassword);
            if (con != null) {
                return con;

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static UserAccount findUser(String userName, String password) throws SQLException {
        //UserAccount u = mapUsers.get(userName);
        UserAccount u=new UserAccount();
        try{
        Connection con = getConnect();
        /*List <UserAccountr> user=new List<UserAccountr> ();
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }*/
        /*Statement stmt = conn.createStatement();
        ResultSet rs;*/

        //rs = stmt.executeQuery("SELECT * FROM member WHERE uname=userName");
        PreparedStatement ps=con.prepareStatement("SELECT * FROM member WHERE uname=?");
        ps.setString(1,userName);
        ResultSet rs=ps.executeQuery();

        while ( rs.next() ) {

            if (rs.getString(1) != null && rs.getString(2).equals(password)) {
                u.setPassword(rs.getString(2));
                u.setUserName(rs.getString(1));
                u.setGender(rs.getString(4));
                u.setRoles(rs.getString(3));


                return u;
            }
        }
        con.close();}
        catch (Exception ex){ex.printStackTrace();}

        return u;
    }

}
