<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>

<style>
form {
  border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  display: inline-block;
  border: 1px solid #ccc;
}

button {
  background-color: grey;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
.container {
  padding: 16px;
}
</style>

</head>
<body>
<form action="NavigationServlet" method="post">

  <div class="container">
      <h1>Admin Login</h1>
    <label for="adminUserName"><b>Admin Username</b></label>
    <input type="text" placeholder="Enter Username" name="adminUserName" required>

    <label for="password"><b>Admin Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <li><button name="submit" type="submit" value="adminLogin">Admin Login</button></li>
  
  </div>
</form>
</body>
</html>