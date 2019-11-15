<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.customer.text.yourPersonalArea" var="yourPersonalArea"/>
    <fmt:message bundle="${locale}" key="locale.user.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.accountId" var="accountId"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.email" var="email"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.changePass" var="changePass"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.updateData" var="updateData"/>


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
        <h1>${yourPersonalArea}</h1>              <%--todo style--%>
    </div>
    <div class="logIn-form-box-2">
        <form action="change-password" class="login-form user-area-form">
            <div class="input-wrapper">
                <p class="user-area-label">${login}</p>
                <input type="text" value="${user}" class="login-form-text">
            </div>
            <div class="input-wrapper">
                <p class="user-area-label">${accountId}</p>
                <input type="text" value="Тут должен быть ID из БД" class="login-form-text">
            </div>
            <div class="input-wrapper">
                <p class="user-area-label">${email}</p>
                <input type="email" value="" class="login-form-text">
            </div>
            <input type="submit" value="${changePass}" class="login-form-button change-pass-button"/>
            <br/>
            <br/>
        </form>
        <form action="controller">
            <input type="hidden" name="command" value="TODO VALUE"/>             <%--            todo value command--%>
            <input type="submit" value="${updateData}" class="join-us-button"/>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
