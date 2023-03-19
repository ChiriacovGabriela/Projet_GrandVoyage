<%--
  Created by IntelliJ IDEA.
  User: chiriacovgabriela
  Date: 19/03/2023
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<a href="${pageContext.request.contextPath}/clientTask">
    Client Task
</a>
||
<a href="${pageContext.request.contextPath}/managerTask">
    Manager Task
</a>
||
<a href="${pageContext.request.contextPath}/userInfo">
    User Info
</a>
||
<a href="${pageContext.request.contextPath}/login">
    Login
</a>
||
<a href="${pageContext.request.contextPath}/logout">
    Logout
</a>

&nbsp;
<span style="color:red">[ ${loginedUser.userName} ]</span>
