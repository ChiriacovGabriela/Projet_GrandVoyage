package com.example.projet_grandvoyage.Servlets;

import java.io.IOException;
import java.util.List;

import com.example.projet_grandvoyage.Persistence.*;
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        Trip trip;
        String action = request.getParameter("action");

        if (action.contentEquals("delete")){
            String tripNameToDelete = request.getParameter("name");
            tripDAO.deleteTrip(tripNameToDelete);
            response.sendRedirect("managerTaskView.jsp");

        }else {
            String tripName = request.getParameter("name");
            String newDescription = request.getParameter("description");
            double newPrice = Double.parseDouble(request.getParameter("price"));
            String newNameDestination = request.getParameter("nameDestination");

            Destination destination = new Destination(newNameDestination);
            boolean recordExists = destinationDAO.checkRecordExistence(destination);
            if (!recordExists) {
                destinationDAO.addDestination(destination);
            }
            trip = new Trip(tripName, destination, newDescription, newPrice);
            switch (action){
                case "create":
                    create(trip, response);
                    break;

                case "update":
                    update(trip,response);
                    break;
        }}
      }
    private void create(Trip trip, HttpServletResponse response )throws  IOException{
        tripDAO.addTrip(trip);
        response.sendRedirect("managerTaskView.jsp");
    }
    private void update(Trip trip,  HttpServletResponse response )throws  IOException{
        tripDAO.updateTrip(trip);
        response.sendRedirect("managerTaskView.jsp");

    }

}
