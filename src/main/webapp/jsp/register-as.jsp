<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.label.welcomeText" var="welcomeText"/>
    <fmt:message bundle="${locale}" key="locale.user.button.joinUs" var="joinUs"/>
    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Register As</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div>
        <form action="customer-register">
            <input class="join-us-button" type="submit" value="Как Заказчик">
        </form>
        <form action="courier-register">
            <input class="join-us-button" type="submit" value="как курьер">
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
