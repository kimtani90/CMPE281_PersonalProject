<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>	
  
  		<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>

      	<link rel="stylesheet" href="./css/style.css">
		
	</head>
	
	
<body>

<form action="LoginServlet">
  <div class="log-form">
  <c:out value="${message}"></c:out>
	<br>
     <h1>Grader Login</h1>
     <div class="form-group ">
       <input type="text" class="form-control" placeholder="Username " name="username">
       <i class="fa fa-user"></i>
     </div>
     <div class="form-group log-status">
       <input type="password" class="form-control" placeholder="Password" name="password">
       <i class="fa fa-lock"></i>
     </div>
      <span class="alert">Invalid Credentials</span>
     
     <button class="log-btn" type="submit" value="submit">Log in</button>
     
  </div>
  
  <div class="button-form">
  	<button class="log-btn" type="submit" value="submit">Tenant 1</button><br><br><br>
  	
    <button class="log-btn" type="submit" value="submit">Tenant 2</button><br><br><br>
    <button class="log-btn" type="submit" value="submit">Tenant 3</button><br><br><br>
    <button class="log-btn" type="submit" value="submit">Tenant 4</button> 
  </div>  
 
</form>
  
</html>
