<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MAIN</title>
    <link href="${pageContext.request.contextPath}/resources/view/css/styles.css" rel="stylesheet" ></head>
</head>

<body>
<div>
<%--    ${all}--%>
    <c:forEach items="${stations}" var="one">
        <p>
                ${one.type}
                ${one.firstStation}
                ${one.lastStation}
                ${one.fullTime}
        </p>
    </c:forEach>
    ${err}
    <%--    <p>FIRST</p>--%>
    <%--    ${first}--%>
    <%--    <p>LAST</p>--%>
    <%--    ${last}--%>
    <%--    <p>TYPE</p>--%>
    <%--    ${type}--%>
    <%--    <p>FULL</p>--%>
    <%--    <p ><a href = "https://www.google.com/">${type} ${first} — ${last}</a></p>--%>
</div>
</body>
</html>