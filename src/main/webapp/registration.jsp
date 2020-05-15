<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>

</head>
<body>

<h1>Registration form</h1><br/>
<form method="post" action="${pageContext.request.contextPath}/registration">
    <input type="text" name="first_name"><br/>
    <input type="text" name="last_name"><br/>
    <input type="text" name="email"><br/>
    <input type="text" name="login"><br/>
    <input type="password" name="password"><br/><br/>
    <input class="button" type="submit" value="submit">

</form>
<br/>
<a href="${pageContext.request.contextPath}/login.jsp">Log in</a>
<br>
<a href="${pageContext.request.contextPath}/index.jsp">Main page</a>
</body>
</html>
