<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Search User</title>
</head>
<body>

<h1>Search Users</h1>

<form action="UserServlet" method="post">


	<input type="text" name="userName" placeholder="Search..">
	<input type="submit" name="userAction" value="searchUser">
	
	
<!-- 	<input id="inputName" type="text" placeholder="Search.."> -->
<!-- 	<br><br> -->
<!-- 	<hr> -->
	
<!-- 	<table> -->
<!-- 	  <thead> -->
<!-- 	  <tr> -->
<!-- 	    <th></th> -->
<!-- 	  </tr> -->
<!-- 	  </thead> -->
	  
<!-- 	  <tbody id="userTable"> -->
<%-- 	  <% for(String eachUser:users){ %> --%>
<!-- 	  <tr> -->
<%-- 	  	<td><img src="test.jpg" alt="<%= eachUser %>" width="10" height="10"></td> --%>
<%-- 	    <td><%= eachUser %></td> --%>
<!-- 	    <td><input type="submit" value="Send Request" name="userAction" ></td> -->
<!-- 	  </tr> -->
<%-- 	  <% } %> --%>
	  
<!-- 	</tbody> -->
<!-- 	</table> -->
	
<!-- 	<br> -->
<!-- 	<hr> -->
	
	<!-- <a href="userHome.jsp" style="text-align: right;">Back To Home</a> -->

</form>

</body>
</html>
