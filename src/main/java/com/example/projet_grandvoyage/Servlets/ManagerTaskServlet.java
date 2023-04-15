package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;
import java.util.List;

import com.example.projet_grandvoyage.Persistence.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.projet_grandvoyage.Trip.*;
import com.example.projet_grandvoyage.Destination.*;

@WebServlet("/managerTask")
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

        List<Trip> trips = tripDAO.listTrips();
        request.setAttribute("trips", trips);
        request.getRequestDispatcher("managerTaskView.jsp").forward(request,response);

        /*RequestDispatcher dispatcher //
                = this.getServletContext()//
                .getRequestDispatcher("/managerTaskView.jsp");

        dispatcher.forward(request, response);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String nameDestination = request.getParameter("nameDestination");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String name = request.getParameter("name");

        Destination destination = new Destination(nameDestination);
        boolean recordExists = destinationDAO.checkRecordExistence(destination);
        if(!recordExists){
            destinationDAO.addDestination(destination);
        }
        Trip trip = new Trip(name, destination, description, price);
        String action = request.getParameter("action");
        if(action != null){
            switch (action){
                case "create":
                    create(trip, response);
                    break;
                case "delete":
                    String tripName = request.getParameter("trip");
                    delete(tripName,response);
                    break;
            }

    }}
    private void create(Trip trip, HttpServletResponse response )throws  IOException{
        tripDAO.addTrip(trip);
        response.sendRedirect("managerTaskView.jsp");
    }
    private void delete(String tripName,HttpServletResponse response )throws  IOException{
        tripDAO.deleteTrip(tripName);
        response.sendRedirect("managerTaskView.jsp");
    }
}
