<%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Manager Task</title>
</head>

<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Manager Task</h3>

<h1>Add a trip</h1>
<form action="ManagerTaskServlet" method="post" >
  <label for="nameDestination">Destination :</label>
  <input type="text" name="nameDestination" id="nameDestination"><br>
  <label for="description">Description :</label>
  <textarea name="description" id="description"></textarea><br>
  <label for="price"> Price :</label>
  <input type="number" name="price" id="price"><br>
  <button type="submit" value="ManagerTaskServlet">Add</button>
</form>


</body>
</html>
