<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->
<table class="table">
<c:forEach items="${books}" var="book" varStatus="loop">
    <tr>    
    <td><c:out value="${book.title}"/></td>
    <td><c:out value="${book.author}"/></td>
    <td><c:out value="${book.description}"/></td>
    <td><c:out value="${book.isbn}"/></td>
    <td><a href="/books/delete/${loop.index}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<form method="GET" action="/books/search">
	<label for="query">Search for books:</label>
	<input type="text" name="query"/>
	<input type="submit" value="Search"/>
</form>
<c:choose>
	<c:when test="${searchResults.totalItems==undefined}">
		<div>
			<p>Perform a search!</p>
		</div>
	</c:when>
	<c:when test="${searchResults.totalItems==0}">
		<div>
			<p>Search produced no results.</p>
		</div>
	</c:when>
	<c:otherwise>
		<ul>
		<c:forEach items="${searchResults.items }" var="item">
			<li>Author: <c:out value="${item.volumeInfo.authors[0]}"/></li>
		</c:forEach>
		</ul>
	</c:otherwise>
</c:choose>
<!-- ... -->