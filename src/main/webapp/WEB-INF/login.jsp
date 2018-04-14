<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Sxolion | Login</title>
	<style>
		form{
			display: flex;
			flex-direction: column;
			align-items: left;
			width: 500px;
		}
		
		.form-field{
			padding: 10px;
		}
		
		label{
			padding-right: 10px;
		}
		
		label[for="email"]{
			padding-right: 32px;
		}
		
	</style>
</head>

<body>
	<h1>Welcome to Sxolion. Please Log In.</h1>
	
	<form method="POST" action="/login">
		<p class="form-field">
			<label for="email">Email:</label>
			<input type="text" id="email" name="email"/>
		</p>
		
		<p class="form-field">
			<label for="password">Password:</label>
			<input type="password" id="password" name="password"/>
		</p>
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
		<input type="submit" value="Login"/>
	</form>
	
</body>

</html>