<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@500&display=swap" rel="stylesheet">  
<style>
        body {
            margin: 0px;
            padding: 0px;
            background:#f08080;
            font-family: 'Oswald', sans-serif;       
              }
        .left {
            display: inline-block;
            position: absolute;
            left: 60px;
            top: 20px;
        }

        .left img {
            width: 136px;
            filter: invert(100%)
        }

        .left div {
            text-align: center;
            line-height: 19px;
            font-size: 26px;
        }

        .mid {
            display: block;
            width: 54%;
            margin: 20px auto;
        }

        .right {
            display: inline-block;
            position: absolute;
            right: 34px;
            top: 40px;
        }

        .navbar {
            display: inline-block;
        }

        .navbar li {
            display: inline-block;
            font-size: 25px;
        }

        .navbar li a {
            color: black;
            text-decoration: none;
            padding: 34px 23px;
        }

        .navbar li a:hover,
        .navbar li a:active {
            text-decoration: underline;
            color: grey;
        }

        .btn {
            margin: 0px 9px;
            color: white;
            background-color: black;
            padding: 4px 14px;
            border: 2px solid grey;
            border-radius: 10px;
            font-size: 15px;
            cursor: pointer;
            font-family: 'Oswald', sans-serif;        
            }

        .btn:hover {
            background-color: grey;
        }

        .container {
            border: 2px solid whitesmoke;
            margin: 106px 60px;
            padding: 40px;
            width: 30%;
            border-radius: 28px;
        }

        .form-group input {
            text-align: center;
            display: block;
            padding: 1px;
            width: 350px;
            border: 2px solid black;
            margin: 11px auto;
            border-radius: 8px;
            font-size: 25px;
            font-family: 'Oswald', sans-serif;
        }
        .container h1 {
            text-align: center;
        }
        .container button {
            display: block;
            width: 78%;
            margin: 20px auto;
        }
        ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		}
    </style>  
</head>
<body>
<h1>Hello ${ userName } </h1>
<header class="header">
        <form action="AdminServlet" method="get">

    <div>
            <ul class="navbar">
            	<li><button name="adminAction" type="submit" value="showSummary">View Statistics</button></li>
            	<li><button name="adminAction" type="submit" value="disableUser">Disable User</button></li>
            	<li><button name="adminAction" type="submit" value="deleteUser">Delete User</button></li>
            	<li><button name="adminAction" type="submit" value="adminLogout">log out</button></li>
            </ul>
   </div>
    
</form>
</header>
</body>
</html>