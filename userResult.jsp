<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Result</title>
</head>
<body>


<h1>User Result</h1>

 ${ result }
 
 <form action="UserServlet" method="post">
	
	<input type="hidden" name="userAction" value="backToHome">
	<input type="submit" value="Back">

</form>
</body>
</html>