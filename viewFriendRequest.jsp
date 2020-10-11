<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Friend Request</title>
</head>
<body>


<h1>Friend Requests</h1>

<form action="UserServlet" method="post">

	  	<p><img src="${ friendList.image }" alt="user" width="10" height="10"><span> ${ friendList.name } </span> Sent a Friend Request...</p>
	  	<br>
	  	<button type="submit" name="sendRequest" value="sendRequest">Accept</button>
	  	<button type="submit" name="declineRequest" value="declineRequest">Ignore</button>
	  	<button type="submit" name="blockUser" value="blockUser">Block</button>
	
	<!-- <a href="userHome.jsp" style="text-align: right;">Back To Home</a> -->

</form>

</body>
</html>