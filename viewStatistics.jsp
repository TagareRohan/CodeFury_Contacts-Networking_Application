  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Statistics</title>
</head>
<body style="background-color:powderblue;">
<h1 style="background-color:tomato; text-align: center;">User Statistics</h1>
<p>${viewStatistics}</p>
<form action="AdminServlet" method="post">
<button type="submit" name="adminAction" value="back">Back to Home</button>
</form>
</body>
</html>