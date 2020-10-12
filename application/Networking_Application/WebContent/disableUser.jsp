<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disable Users</title>
</head>
<body>

<form action="AdminServlet" method="post">
<ul>
<c:forEach items="${disableList}" var="user">
    <li><c:out value="${user.getUsername()}"/></li>

</c:forEach>
</ul>
<button type="submit" name="adminAction" value="disableUsers">Disable</button>

</form>

</body>
</html>