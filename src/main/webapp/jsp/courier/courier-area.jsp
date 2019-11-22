<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.user.button.back" var="back"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.yourPersonalArea" var="yourPersonalArea"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.accountId" var="accountId"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.changePass" var="changePass"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.updateData" var="updateData"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.myBalance" var="myBalance"/>



    <link rel="stylesheet" href="./css/style.css">
    <title>Personal area</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div>
        <br/>
        <h2>${yourPersonalArea}</h2>
    </div>
    <div class="logIn-form-box-2">
        <div class="login-form user-area-form">
            <div class="input-wrapper">
                <p class="user-area-label">${login}: ${sessionScope.user.login}</p>
            </div>
            <div class="input-wrapper">
                <p class="user-area-label">${accountId}: ${sessionScope.user.id}</p>
            </div>
        </div>
        <form action="change-password">
            <input type="submit" value="${changePass}" class="join-us-button"/>
        </form>
        <form>
            <input type="button" value="${back}" class="join-us-button" onclick="history.back()">
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
