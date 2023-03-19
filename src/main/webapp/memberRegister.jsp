<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register a member</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
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
        <input type="radio" id="CLIENT" name="role" value="CLIENT">
        <label for="CLIENT">CLIENT</label>
      </div>
      <div>
        <input type="radio" id="MANAGER" name="role" value="MANAGER">
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
