<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Users</title>
</head>
<body>

<form action="AdminServlet" method="post">

<c:forEach items="${deleteList}" var="user">

    <c:out name="deleteList" value="${user.getFullName()}"/>

</c:forEach>

<button type="submit" name="adminAction" value="deleteUsers">Delete</button>

</form>


</body>
</html>