<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<p><c:out value="${shelf.name}"/></p>
<ul>
<c:forEach items="${shelf.books}" var="book">
<li>${book.title}</li>
</c:forEach>
</ul>
