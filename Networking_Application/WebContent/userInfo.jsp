<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css"><link>
<script>
$(document).ready(function(){
  $("#inputName").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#userTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

<meta charset="ISO-8859-1">
<title>User Info</title>
</head>
<body>

<h1>User Found..</h1>
${userInfo}	
<form action="UserServlet" method="post">
 <button type="submit" name="userAction" value="sendRequest">Send Request</button>
</form>
	
</body>
</html>
