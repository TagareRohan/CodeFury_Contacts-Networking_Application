<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
{box-sizing: border-box}
.container {
  padding: 16px;
}
input[type=text], input[type=password],input[type=tel],input[type=email],input[type=date]{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus,input[type=tel]:focus,input[type=email]:focus{
  background-color: #dddd;
  outline: none;
}
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
.btn {
  background-color: grey;
  color: black;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.btn:hover {
  opacity:1;
}
a {
  color: #59c2f0;
}
h1{
	text-align: center;
}
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>
<form action="">
  <div class="container">
    <h1>Register</h1>
    <hr>
    <label for=fullName"><b>Full Name</b></label>
    <input type="text" placeholder="Enter full name" name="fullName" id="fullName" required>
    <label for="Email"><b>Email</b></label>
    <input type="email" placeholder="Enter email" name="Email" id="Email" required>
    <label for="PhoneNum"><b>Phone Number</b></label>
    <input type="tel" placeholder="Enter Phone Number" name="phoneNum" id="phoneNum">
    <div>
	    <p><b>Gender</b></p>
	    <label for="male">Male</label>
	    <input type="radio" id="male" name="gender" value="male" id="male">
	    <label for="female">Female</label>
	    <input type="radio" id="female" name="gender" value="female">
	  	<label for="other">Other</label>
	  	<input type="radio" id="other" name="gender" value="other">
    </div><br>
    <label for="dateOfBirth"><b>Date of Birth</b></label>
  	<input type="date"  placeholder="Enter Date of Birth" id="dateOfBirth" name="dateOfBirth">
  	<div>
  		<label for="address"><b>Address</b></label>
	  	<input type="text"  placeholder="Enter address" id="address" name="address">
	  	<label for="city">City</label>
	  	<input type="text"  placeholder="Enter city" id="city" name="city">
	  	<label for="state">State</label>
	  	<input type="text"  placeholder="Enter state" id="state" name="state">
	  	<label for="country">Country</label>
	  	<input type="text"  placeholder="Enter country" id="country" name="country">
  	</div>
  	
    <label for="company"><b>Company</b></label>
    <input type="text" placeholder="Enter Company" name="company" id="company" required>
    <label for="userName"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="UserName" id="UserName" required>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
     <label for="profPicture"><b>Upload image:</b></label><br>
  		<input type="file" id="profPicture" name="profPicture" accept="image/*">
  		
    <hr>

    <button type="submit" class="btn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="UserLogin.jsp">Login</a>.</p>
  </div>
</form>
</html>