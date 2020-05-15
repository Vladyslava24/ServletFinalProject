<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<%!
    String getFormattedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return sdf.format(new Date());
    }
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="bootstrap-grid.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">-->
    <title>Basic project</title>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Book storage</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/editions">Catalog</a>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/login">Login</a>
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}/registration">Registration</a>
        <a class="p-2 text-dark" href="#">Каталог</a>
    </nav>
</div>
<h2>
    Hello from basic project! <br/>
    <i>Сегодня <%= getFormattedDate() %></i>
</h2>
<h4>Система Периодические издания</h4>
Администратор осуществляет<br>
ведение каталога периодических Изданий. Читатель может оформить<br/>
Подписку, предварительно выбрав периодические Издания из списка.<br/>
Система подсчитывает сумму для оплаты и регистрирует Платеж.
<br/>
<a href="${pageContext.request.contextPath}/login">Please log in</a>
<br>
<a href="${pageContext.request.contextPath}/registration">Registration page</a>
<br>
<a href="${pageContext.request.contextPath}/exception">Exception</a>
<br>
<a href="${pageContext.request.contextPath}/changeLocale.jsp">Change Locale</a>

</body>
</html>