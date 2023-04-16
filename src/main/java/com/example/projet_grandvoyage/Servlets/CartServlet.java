package com.example.projet_grandvoyage.Servlets;

import com.example.projet_grandvoyage.Cart.Cart;
import com.example.projet_grandvoyage.Destination.Destination;
import com.example.projet_grandvoyage.Persistence.CartDAO;
import com.example.projet_grandvoyage.Persistence.DestinationDAO;
import com.example.projet_grandvoyage.Persistence.TripDAO;
import com.example.projet_grandvoyage.Trip.Trip;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private CartDAO cartDAO;
    private DestinationDAO destinationDAO;

    private  TripDAO tripDAO;
    private static final long serialVersionUID = 1L;
    public CartServlet() {
        super();
    }

    public void init() throws ServletException {
        cartDAO = new CartDAO();
        destinationDAO = new DestinationDAO();
        tripDAO = new TripDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CartDAO cartDAO = new CartDAO();
        List<Trip> tripsCart = cartDAO.getTrips();
        request.setAttribute("tripsCart", tripsCart);

        request.getRequestDispatcher("clientTaskView.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] selectedTrips = request.getParameterValues("selectedTrips");
        if (selectedTrips != null) {
            for (String nameTrip : selectedTrips) {
                List<Trip> trupa = tripDAO.listTrips();
                for(Trip element: trupa) {
                    if(element.getName()==nameTrip){
                        cartDAO.addTrip(element);
                    }
                }
            }
        }

        response.sendRedirect("clientTaskView.jsp");



    }

}

