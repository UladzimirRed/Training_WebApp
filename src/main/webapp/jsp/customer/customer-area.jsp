<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Personal area</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div class="logIn-form-box">
        <form action="/jsp/change-password.jsp" class="login-form user-area-form">
            <div class="input-wrapper">
                <p class="user-area-label">LOGIN</p>
                <input type="text" value="${user}" class="login-form-text">
            </div>
            <div class="input-wrapper">
                <p class="user-area-label">Номер аккаунта</p>
                <input type="text" value="${id}" class="login-form-text">
            </div>
            <div class="input-wrapper">
                <p class="user-area-label">E-mail</p>
                <input type="email" value="" class="login-form-text">
            </div>
            <input type="submit" value="change password" class="login-form-button change-pass-button"/>
            <hr>
            <form action="controller">
                <input type="submit" value="refresh data" class="login-form-button"/>
            </form>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
