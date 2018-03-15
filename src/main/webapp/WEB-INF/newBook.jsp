<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->
<form:form method="POST" action="/books/new" modelAttribute="book">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    
    <form:label path="author">Author
    <form:errors path="author"/>
    <form:input path="author"/></form:label>

    <form:label path="description">Description
    <form:errors path="description"/>
    <form:textarea path="description"/></form:label>
    
    <form:label path="isbn">ISBN
    <form:errors path="isbn"/>     
    <form:input path="isbn"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
<!-- ... -->