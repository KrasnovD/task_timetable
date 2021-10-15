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
    Маршруты
</header>
<section>
<div>
    <c:forEach items="${all}" var="one">
        <p>
            <a href="/${one.id}">${one.firstStation} — ${one.lastStation}</a><br>Дни курсирования:
                ${one.type}
        </p>
    </c:forEach>
</div>
</section>
<footer>
        <a href="/">Главная</a>
</footer>
</body>
</html>