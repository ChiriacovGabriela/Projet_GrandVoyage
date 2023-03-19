<%--
  Created by IntelliJ IDEA.
  com.example.projet_grandvoyage.User: andra
  Date: 19/03/2023
  Time: 12:22
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
      <td>Address</td>
      <td><input type="text" name="address"></td>
    </tr>
    <tr>
      <td>Gender</td>
      <td>
        <div>
          <input type="radio" id="M" name="gender" value="M">
          <label for="M">M</label>
        </div>
        <div>
          <input type="radio" id="F" name="gender" value="F">
          <label for="F">F</label>
        </div>
      </td>
    </tr>
    <tr>
      <td>Role</td>
      <td>
      <div>
        <input type="radio" id="CLIENT" name="roles" value="CLIENT">
        <label for="CLIENT">CLIENT</label>
      </div>
      <div>
        <input type="radio" id="MANAGER" name="roles" value="MANAGER">
        <label for="MANAGER">MANAGER</label>
      </div>
      </td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="register"></td>
    </tr>
  </table>

</form>

</body>
</html>
