<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blocked Accounts</title>
</head>

<body style="background-color:powderblue;">
<h1 style="background-color:tomato; text-align: center;">Blocked accounts</h1>
<p>${viewBlockedList}</p>
<form action="UserServlet" method="post">
<button type="submit" name="userAction" value="back" style="background-color:tomato;">Back to Home</button>
</form>

</body>
</html>