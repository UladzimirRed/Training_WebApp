<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.label.welcomeText" var="welcomeText"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Courier Exchange</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <jsp:forward page="/main"/>
    </c:when>
</c:choose>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main>
    <div class="welcome-box">
        <span class="welcome-text">${welcomeText}</span>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
