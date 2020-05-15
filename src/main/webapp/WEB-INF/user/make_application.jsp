<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application page</title>

</head>
<body>
<h4>See you application here</h4>
<h5>Here your selected editions</h5>
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
        </tr>
    </c:forEach>
</table>
<p>Summary cost is:<c:out value="${cost}"></p>
<a herf="/make_order">Make order</a>
</body>
</html>
