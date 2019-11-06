<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="resources.locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.successChangeLocale" var="successChangeLocale"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Info</title>
</head>

<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<div class="container">
    <div class="message-container">
        <c:choose>
            <c:when test="${requestScope.message == 'changedLocale'}">
                ${successChangeLocale}
            </c:when>
        </c:choose>
    </div>
</div>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
