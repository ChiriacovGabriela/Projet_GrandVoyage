package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;
import java.util.List;
import com.example.projet_grandvoyage.Persistence.*;

import com.example.projet_grandvoyage.Trip.Trip;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientTask")
public class ClientTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ClientTaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TripDAO tripDAO = new TripDAO();

        List<Trip> trips = tripDAO.listTrips();
        request.setAttribute("trips", trips);
        request.getRequestDispatcher("clientTaskView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
