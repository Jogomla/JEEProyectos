<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<h2>Usuarios</h2>
<c:if test="${empty usuarios}">No existen usuarios</c:if>
<c:forEach items="${usuarios}" var="user">
    Email : ${user.email}
    <br>
    Password : ${user.password}
    <br>
    <br>
</c:forEach>
</body>
</html>
