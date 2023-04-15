<%@ page import="com.example.projet_grandvoyage.Persistence.TripDAO" %>
<%@ page import="com.example.projet_grandvoyage.Trip.Trip" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Manager Task</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>



<h1> Trip</h1>
<form action="managerTask" method="post" >
  <table>
    <tr><td></td>
      <td><input type="hidder" name="action" value="create">
      </td>
    </tr>
    <tr>
      <td>
        <label for="name">Name :</label>
      </td>
      <td>
        <input type="text" name="name" id="name">
      </td>
    </tr>
    <tr>
      <td>
        <label for="nameDestination">Destination :</label>
      </td>
      <td>
        <input type="text" name="nameDestination" id="nameDestination"><br>
      </td>
    </tr>
    <tr>
      <td>
        <label for="description">Description :</label>
      </td>
      <td>
        <textarea name="description" id="description"></textarea><br>
      </td>
    </tr>
    <tr>
      <td>
        <label for="price"> Price :</label>
      </td>
      <td>
        <input type="number" name="price" id="price"><br>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Create">
      </td>
      <td>
      </td>
    </tr>
  </table>
</form>


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
      <td>
        <form action="managerTask" methode="post">
          <input type="hidden" name="trip" value="<%= trip.getName() %>"/>
          <input type="hidder" name="action" value="delete"/>
          <input type="submit" value="Supprimer"/>
        </form>
      </td>
    </tr>
 <%}%>
</table>


</body>
</html>
