  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Statistics</title>
</head>
<body style="background-color:powderblue;">
<h1 style="background-color:tomato; text-align: center;">User Statistics</h1>
<p>${summary}</p>
<form action="AdminServlet" method="get">
<button type="submit" name="adminAction" value="backToHome">Back to Home</button>
</form>
</body>
</html>