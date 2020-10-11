<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body style="background-color:powderblue;">
<form action="UserServlet" method="post">

<div>
    <div>
            <ul class="navbar">
            	<li><button name="userAction" type="submit" value="searchUser">Search</button></li>
            	<li><button name="userAction" type="submit" value="viewContactList">My Contacts</button></li>
            	<li><button name="userAction" type="submit" value="viewFriendList">My Friends</button></li>
            	<li><button name="userAction" type="submit" value="viewFriendRequests">Friend Requests</button></li>
            	<li><button name="userAction" type="submit" value="addNewContact">Add new Contact</button></li>
            	<li><button name="userAction" type="submit" value="viewBlockedList">Blocked Accounts</button></li>
            </ul>
        </div>
        	<!--<h1 style="background-color:tomato;">${fullName}</h1> -->
        	<h1 style="background-color:tomato;">Hello${userName}</h1>
            <!--<img src="${profPicture}" alt="User Profile picture if present" style="width:500px;height:600px;"> -->
</div>
    
</form>
<form action="NavigationServlet" method="post">
<button name="logout" type="submit" value="userLogout">Logout</button>
</form>
</html>