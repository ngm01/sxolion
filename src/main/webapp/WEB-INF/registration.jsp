<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Sxolion | Register</title>
	</head>
	
	<body>
		<h1>Please Register.</h1>
		
		<p><form:errors path="user.*"/></p>
		
		<form:form method="POST" action="/registration" modelAttribute="user">
			<p>
				<form:label path="email">Email address:</form:label>
				<form:input path="email"/>
			</p>
			<p>
				<form:label path="password">Password: </form:label>
				<form:password path="password"/>
			</p>
			<p>
				<form:label path="passwordConf">Confirm password: </form:label>
				<form:password path="passwordConf"/>
			</p>
			<input type="submit" value="Register"/>
		</form:form>
	</body>
</html>