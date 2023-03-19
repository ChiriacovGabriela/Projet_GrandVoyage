package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;

import com.example.projet_grandvoyage.Persistence.*;
import com.example.projet_grandvoyage.User.UserAccount;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {



    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/memberRegister.jsp");

        dispatcher.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String gender=request.getParameter("gender");
        String role=request.getParameter("role");

        UserAccount user=new UserAccount(uname, password, email, phone, address, gender, role);
        RegisterDao rdao=new RegisterDao();
        String result=rdao.insert(user);
        response.getWriter().println(result);


    }

}
