<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add New Edition</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/add_edition" method="post">
        <h3>New edition</h3>
        <input class="form-control form-group" type="text" name="name" placeholder="Name">
        <input class="form-control form-group" type="text" name="author" placeholder="Author">

       <button type="submit" class="btn btn-default">Add Edition</button>
    </form>
</div>
</body>
</html>
