<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>S&#967;olion | Welcome</title>
</head>
<h1>Welcome to S&#967;olion!</h1>
<p>S&#967;olion (pronounced <em>sko&#183;lee&#183;on</em>, from <a href="https://en.wikipedia.org/wiki/Scholia">the Greek</a>) is an application designed to help you keep track of books.</p>
<p>You can add books to virtual shelves, and view others' books as well!</p>
<p>Eventually you will be able to create QR codes linking your real-world book shelves and storage to these virtual containers.</p>
<p>Happy reading.</p>
<a href="/shelves">View Your Shelves</a>
<a href="/books">Search for Books</a>
<form id="logoutForm" method="POST" action="/logout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout"/>
</form>

<div id="bookList">
<h1>Your books:</h1>
<ul>
	<c:forEach items="${usersBooks}" var="book">
		<li>${book.title}</li>
	</c:forEach>
</ul>
</div>