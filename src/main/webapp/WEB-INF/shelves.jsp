<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<table class="table">
<c:forEach items="${shelves}" var="shelf" varStatus="loop">
    <tr>    
    <td><c:out value="${shelf.name}"/></td>
    <td><a href="/shelves/delete/${loop.index}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<!-- ... -->