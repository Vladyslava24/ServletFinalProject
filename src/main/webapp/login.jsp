<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Login in system</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>

<h1><fmt:message key="welcome"/></h1><br/>
<div class="container mt-5">
<form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="label.login"/></h1>
    </div>

    <div class="form-label-group">
        <input type="login" name="login" id="inputLogin" class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputLogin"><fmt:message key="enter.login"/></label>
    </div>

    <div class="form-label-group">
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
        <label for="inputPassword"><fmt:message key="enter.password"/></label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="button.submit"/></button>
</form>
</div>
<br/>
<a href="${pageContext.request.contextPath}/index">На головну</a>

</body>
</html>