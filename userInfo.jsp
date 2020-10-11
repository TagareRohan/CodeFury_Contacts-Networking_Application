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

<table>
	  <thead>
	  <tr>
	    <th></th>
	  </tr>
	  </thead>
	  
	  <tbody id="userTable">
	  
	  <tr>
	  	<td><img src="${ userInfo.image }" alt="${ userInfo.name }" width="10" height="10"></td>
	    <td>${ userInfo.name }</td>
	    <td><button type="submit" value="sendRequest" name="sendRequest" >Send Request</button></td>
	  </tr>
	
	  
	</tbody>
	</table>
	
	
</body>
</html>
