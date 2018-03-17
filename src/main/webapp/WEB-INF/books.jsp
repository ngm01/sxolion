<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- ... -->
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
		<c:forEach items="${searchResults.items }" var="item">
			<div class="search-results-book">
				<h3><c:out value="${item.volumeInfo.title}"/></h3>
				<div class="search-results-book-body">
					<img src="${item.volumeInfo.imageLinks.smallThumbnail}"/>
					<div class="search-results-book-body-text">
						<p>
							<c:forEach items="${item.volumeInfo.authors}" var="author" varStatus="loop">
							<c:out value="${author}"/><c:if test="${loop.index lt fn:length(item.volumeInfo.authors)-1}">,</c:if>
						</c:forEach>
						</p>
						<p><c:out value="${item.volumeInfo.publishedDate}"/></p>
						<p><c:out value="${fn:substring(item.volumeInfo.description, 0, 100)}"/>...</p>
						<p>
							<a href="${item.volumeInfo.previewLink}" target="_blank">Google Books Preview</a>
						</p>
					</div>
				</div>
			</div>

		</c:forEach>
	</c:otherwise>
</c:choose>
<!-- ... -->