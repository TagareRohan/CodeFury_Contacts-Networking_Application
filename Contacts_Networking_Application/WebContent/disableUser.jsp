<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disable Users</title>
</head>
<body>

<form action="AdminServlet" method="post">

<c:forEach items="${disableList}" var="user">

<c:out value="${user}"/>

<input type="hidden" name="disableList" value="${user}">
    
</c:forEach>


<button type="submit" name="adminAction" value="disableUsers">Disable</button>

</form>



</body>
</html>