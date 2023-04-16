package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;

import com.example.projet_grandvoyage.Persistence.UpdateDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.projet_grandvoyage.User.*;

@WebServlet(name="UpdateServlet", value="/update")
public class UpdateServlet extends HttpServlet {

    public UpdateServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/editAccountView.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name=request.getParameter("uname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String gender=request.getParameter("gender");
        String role=request.getParameter("role");

        UserAccount user=new UserAccount();

        user.setUname(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setGender(gender);
        user.setRole(role);

        String result=UpdateDAO.update(user);
        response.getWriter().println(result);

    }

}

