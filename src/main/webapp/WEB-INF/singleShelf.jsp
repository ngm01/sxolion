<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<p><c:out value="${shelf.name}"/></p>
<img src="<c:url value="../static/qrcodes/${shelf.id}.png" />">
<ul>
<c:forEach items="${shelf.books}" var="book">
<li>${book.title}</li>
</c:forEach>
</ul>
