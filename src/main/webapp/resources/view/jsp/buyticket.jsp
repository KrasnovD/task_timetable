<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MAIN</title>
    <link href="${pageContext.request.contextPath}/resources/view/css/styles.css" rel="stylesheet" ></head>
    <link type="image/png" sizes="32x32" rel="icon" href="${pageContext.request.contextPath}/resources/view/favicon.ico">
</head>

<body>
<header>
    Рассписание
</header>
<section>
    <div>
        <form class="form" action="/buy/${id}" method="post">
            <input type="text" name="name" placeholder="Имя" required>
            <input type="text" name="surname" placeholder="Фамилия" required>
            <input type="tel" name="text" placeholder="Номер паспорта" required>
            <input type="date" name="date" required min=${date}>
            <input type="submit" value="КУПИТЬ">
        </form>
    </div>
</section>
<footer>
    <a href="/allroutes">Все маршруты</a>
</footer>
</body>
</html>