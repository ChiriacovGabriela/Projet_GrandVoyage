<%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register a member</title>
</head>
<body>
<form action="Register" method="post">
  <table>
    <tr>
      <td>User Name</td>
      <td><input type="text" name="uname"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="email"></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="register"></td>
    </tr>
  </table>



</form>

</body>
</html>
