<%@ page import="com.example.projet_grandvoyage.Trip.Trip" %>
<%@ page import="com.example.projet_grandvoyage.Persistence.TripDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
  <title>Trips</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<h2>List of available trips </h2>
<table>
  <tr>
    <th> Name </th>
    <th>Destination</th>
    <th>Description</th>
    <th>Price</th>
  </tr>
  <%
    TripDAO tripDAO = new TripDAO();
    List<Trip> tripList = tripDAO.listTrips();
    for(Trip trip: tripList){
  %>
  <tr>
    <td><%= trip.getName() %></td>
    <td><%= trip.getDestination().getName() %></td>
    <td><%= trip.getDescription() %></td>
    <td><%= trip.getPrice() %></td>
  </tr>
  <%}%>
</table>

</body>
</html>

