<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->
<form:form method="POST" action="/shelves/new" modelAttribute="shelf">
    <form:label path="name">Shelf Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>

    <input type="submit" value="Submit"/>
</form:form>