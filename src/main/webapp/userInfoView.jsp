<%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User Info</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h3>Hello: ${loginedUser.userName}</h3>

User Name: <b>${loginedUser.userName}</b>
<br />
Gender: ${loginedUser.gender } <br />


</body>
</html>
