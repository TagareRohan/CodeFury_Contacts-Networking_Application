<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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

<input id="inputName" type="text" placeholder="Search..">
<br><br>

<table>
  <thead>
  <tr>
    <th>Firstname</th>
  </tr>
  </thead>
  <tbody id="userTable">
  <tr>
    <td>John</td>
    <td><a href="#" >Send Request</a></td>
  </tr>
  <tr>
    <td>Mary</td>
    <td><a href="#" >Send Request</a></td>
  </tr>
  <tr>
    <td>July</td>
    <td><a href="#" >Send Request</a></td>
  </tr>
  <tr>
    <td>Anja</td>
    <td><a href="#" >Send Request</a></td>
  </tr>
  </tbody>
</table>
<br>
<hr>
<a href="userHome.jsp">Back To Home</a>
</body>
</html>