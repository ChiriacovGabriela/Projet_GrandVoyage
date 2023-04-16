<%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 15/04/2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Trips</title>
</head>
<body>
    <title>List of available trips </title>
    <table>
        <tr>
            <th> Name </th>
            <th>Destination</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach var="trip" itemps="${trips}">
        <tr>
            <td>${trip.getName()}</td>
            <td>${trip.getDestination()}</td>
            <td>${trip.getDescription()}</td>
            <td>${trip.getPrice()}</td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
