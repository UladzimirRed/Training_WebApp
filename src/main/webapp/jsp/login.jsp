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
    <fmt:message bundle="${locale}" key="locale.user.label.signUp" var="signUp"/>
    <fmt:message bundle="${locale}" key="locale.user.button.log_in" var="log_in"/>
    <fmt:message bundle="${locale}" key="locale.user.placeholder.myUserNameIs" var="myUserNameIs"/>
    <fmt:message bundle="${locale}" key="locale.user.placeholder.enterYourPassword" var="enterYourPassword"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Login</title>
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
<main class="main">
    <div class="logIn-form-box">
        <form name="LoginForm" method="POST" action="controller" class="login-form">
            <input type="hidden" name="command" value="login"/>
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
            ${errorLoginPassMessage}
            <input type="submit" value="${log_in}" class="login-form-button"/>
            <div class="login-form-message">
                <c:choose>
                    <c:when test="${not empty requestScope.wrongData}">
                        ${wrongCredentials}
                    </c:when>
                </c:choose>
            </div>
        </form>
        <form action="register-as" class="login-form">
            <input type="submit" value="${signUp}" class="login-form-button"/>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
