<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>The Dynamic Bank</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./styles/styles.css">
</head>

<body>
	<h1 class="center">The Great Bank</h1>
	
	<!-- registered users --> 
	<h2 class="center">Current Customers Sign In</h2>
	
	<form class="container" action="RegistrationServlet" method="get">
	
	  <div class="form-group">
		<label for="userName">User Name</label>
		<input type="text" class="form-control" name="userName" id="userName" placeholder="User Name">
	  </div>
	  
	  <div class="form-group">
		<label for="exampleInputPassword1">Password</label>
		<input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
	  </div>
	  
	  <button type="submit" class="btn btn-default">Sign In</button>
	  
	</form>
	
	<!----------------------------------------------------------->
	
	<!-- new users -->
	<h2 class="center">New Customer Registration</h2>
	
	<form class="container" action="RegistrationServlet" method="get">
	
	  <div class="form-group">
		<label for="firstName">First Name</label>
		<input type="text" class="form-control" name="firstName" id="firstName" placeholder="First Name">
	  </div>
	  <div class="form-group">
		<label for="lastName">Last Name</label>
		<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last Name">
	  </div>
	  <div class="form-group">
		<label for="email">Email address</label>
		<input type="email" class="form-control" name="email" id="InputEmail2" placeholder="Email">
	  </div>
 	  
	  <br>Address<br>
	  
	  <div class="form-group">
		<label for="street">Street</label>
		<input type="text" class="form-control" name="street" id="street" placeholder="Street">
	  </div>

	  <div class="form-group">
		<label for="city">City</label>
		<input type="text" class="form-control" name="city" id="city" placeholder="City">
	  </div>

	  <div class="form-group">
		<label for="state">State</label>
		<input type="text" class="form-control" name="state" id="state" placeholder="State">
	  </div>
	  
	  <div class="form-group">
		<label for="zipCode">ZIP Code</label>
		<input type="text" class="form-control" name="zipCode" id="zipCode" placeholder="ZIP Code">
	  </div>
	  
	  <br>Create a new User/password<br>

	  <div class="form-group">
		<label for="userName">User Name</label>
		<input type="text" class="form-control" name="userName" id="userName" placeholder="User Name">
	  </div>
	  <div class="form-group">
		<label for="exampleInputPassword1">Password</label>
		<input type="password" class="form-control" name="password" id="InputPassword2" placeholder="Password">
	  </div>
	  
	  <button type="submit" class="btn btn-default">Register</button>
	  
	</form>
</body>
</html>