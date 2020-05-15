<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>

</head>
<body>

<h1>Hello USER!</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <td></td>
        <td><b>№</b></td>
        <td><b>Name</b></td>
        <td><b>Author</b></td>
        <td><b>Price</b></td>
        <td><b>Amount edition</b></td>
        <td><b>Status</b></td>
        <td><b>Amount available</b></td>
    </tr>
    </thead>
    <c:forEach items="${editions}" var="edition">
        <tr>
            <td><input type="checkbox" name="id" value="${edition.id}" id="checkbox_${edition.id}"/></td>
            <td>${edition.id}"</td>
            <td>${edition.name}</td>
            <td>${edition.author}</td>
            <td>${edition.price}</td>
            <td>${edition.amountEdition}</td>
            <td>${edition.editionStatus}</td>
            <td>${edition.amountAvailable}</>
            <c:choose>
                <c:when test="${contact.group ne null}">
                    <td>${contact.group.name}</td>
                </c:when>
                <c:otherwise>
                    <td>Default</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</div>
<a href="${pageContext.request.contextPath}/make_application">Make Application</a>
<a href="${pageContext.request.contextPath}/application_list">All applications</a>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>