package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.example.projet_grandvoyage.Connection.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.projet_grandvoyage.Persistence.*;
import com.example.projet_grandvoyage.Trip.*;
import com.example.projet_grandvoyage.Destination.*;

@WebServlet(name="ManagerTaskServlet", value="/managerTask")
public class ManagerTaskServlet extends HttpServlet {

    private TripDAO tripDAO;
    private DestinationDAO destinationDAO;
    private static final long serialVersionUID = 1L;

    public ManagerTaskServlet() {
        super();
    }

    public void init() throws ServletException {
        tripDAO = new TripDAO();
        destinationDAO = new DestinationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //List<Trip> trips = tripDAO.listTrips();
        //request.setAttribute("trips", trips);
        RequestDispatcher dispatcher //
                = this.getServletContext()//
                .getRequestDispatcher("/managerTaskView.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameDestination = request.getParameter("nameDestination");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnect();

        Destination destination = new Destination(nameDestination);
        destinationDAO.addDestination(destination);
        Trip trip = new Trip(destination, description, price);
        //tripDAO = new TripDAO();
        String result = tripDAO.addTrip(trip);
        System.out.println(nameDestination);
        //response.sendRedirect( "/managerTaskView.jsp");

        response.getWriter().println(result);

        //doGet(request, response);
    }


}
