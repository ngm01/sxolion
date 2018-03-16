<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<c:out value="${searchResults.items[0].volumeInfo.authors[0]}"/>
<!-- ... -->