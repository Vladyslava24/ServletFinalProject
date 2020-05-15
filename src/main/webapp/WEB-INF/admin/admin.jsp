<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <%@ page isELIgnored="false" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../bootstrap-grid.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Admin Catalog</title>
    </head>
</head>
<body>
<h3>Hello ADMIN!</h3>
<div class="container">
    <a href="/">Catalog of Edition</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_contact" class="btn btn-default navbar-btn">Add Contact</button></li>
                    <li><button type="button" id="add_group" class="btn btn-default navbar-btn">Add Group</button></li>
                    <li><button type="button" id="delete_contact" class="btn btn-default navbar-btn">Delete Contact</button></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Groups <span class="caret"></span></a>
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="pattern" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

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
<a href="${pageContext.request.contextPath}/add_edition">Add edition</a>
<br>
<a href="${pageContext.request.contextPath}/delete_edition">Delete edition</a>
<br>
<a href="${pageContext.request.contextPath}/update_edition">Update edition</a>
<br>
<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>