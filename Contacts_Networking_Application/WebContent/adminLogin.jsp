<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/UserServlet" method="post">

<label>User Name</label>
<input type="text" name="adminUserName" id="adminUserName">
<label>Password</label>
<input type="password" name="password" id="password">

<input type="submit" name="submit" value="adminLogin">

</form>

</body>
</html>