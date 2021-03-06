<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->
<h1>Your Shelves</h1>
<form:form method="POST" action="/shelves/new" modelAttribute="shelf">
    <form:label path="name">Shelf Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>

    <input type="submit" value="Submit"/>
</form:form>

<table class="table">
<c:forEach items="${shelves}" var="shelf" varStatus="loop">
    <tr>    
    <td>
    		<a href="/shelves/${shelf.id}">${shelf.name}</a>
    </td>
    <c:if test="${!shelf.defaultShelf }">
    <td><a href="/shelves/delete/${shelf.id}">Delete</a></td>
    </c:if>
    </tr>
</c:forEach>
</table>
<!-- ... -->