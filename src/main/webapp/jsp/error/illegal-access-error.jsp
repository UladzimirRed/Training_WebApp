<%@ page isErrorPage="true" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.illegalAccess" var="illegalAccess"/>
    <fmt:message bundle="${locale}" key="locale.user.button.home" var="home"/>

    <title>Illegal access</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <div class="logIn-form-box">
        <br>
        <h2>${illegalAccess}</h2>
        <br>
        <br>
        <form action="home" class="center-button-container">
            <input type="submit" value="${home}" class="common-button">
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>