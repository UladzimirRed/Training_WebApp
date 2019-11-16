<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>
    <fmt:message bundle="${locale}" key="locale.user.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.user.label.password" var="password"/>
    <fmt:message bundle="${locale}" key="locale.user.label.confirmPassword" var="confirmPassword"/>
    <fmt:message bundle="${locale}" key="locale.user.label.role" var="role"/>
    <fmt:message bundle="${locale}" key="locale.user.label.customer" var="customer"/>
    <fmt:message bundle="${locale}" key="locale.user.label.courier" var="courier"/>
    <fmt:message bundle="${locale}" key="locale.user.label.signUp" var="signUp"/>
    <fmt:message bundle="${locale}" key="locale.user.placeholder.myUserNameIs" var="myUserNameIs"/>
    <fmt:message bundle="${locale}" key="locale.user.placeholder.enterYourPassword" var="enterYourPassword"/>
    <fmt:message bundle="${locale}" key="locale.user.placeholder.confirmYourPassword" var="confirmYourPassword"/>

    <link rel="stylesheet" href="./css/style.css">
    <script src="../../js/main.js"></script>

    <title>Register Page</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <jsp:forward page="../main.jsp"/>
    </c:when>
</c:choose>
<main>
    <div class="logIn-form-box">
        <form name="RegisterForm" method="POST" action="controller" class="login-form">
            <input type="hidden" name="command" value="register"/>
            <input type="hidden" name="role" value="courier"/>
            <span class="form-label">${login}:</span>
            <input class="login-form-text"
                   type="text"
                   name="login"
                   maxlength="32"
                   pattern="[A-Za-z0-9._]{4,}"
                   value=""
                   placeholder="${myUserNameIs}"/>
            <span class="form-label">${password}:</span>
            <input class="login-form-password"
                   type="password"
                   name="password"
                   maxlength="32"
                   pattern="[^<>]{4,}"
                   value=""
                   placeholder="${enterYourPassword}"/>
            <span class="form-label">${confirmPassword}</span>
            <input class="login-form-password"
                   type="password"
                   name="confirmPassword"
                   maxlength="32"
                   pattern="[^<>]{4,}"
                   value=""
                   onkeyup="checkPass()"
                   placeholder="${confirmYourPassword}"/>
            <span class="form-label">${role}</span>
            <select class=form-dropdown name="transport">
                <option class="form-option">Truck</option>
                <option class="form-option">Car</option>
                <option class="form-option">НОГИ</option>
            </select>
            <input type="submit" value="${signUp}" class="login-form-button"/>
            <div class="login-form-message">
                <c:choose>
                    <c:when test="${not empty requestScope.wrongData}">
                        ${wrongCredentials}
                    </c:when>
                </c:choose>
            </div>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
