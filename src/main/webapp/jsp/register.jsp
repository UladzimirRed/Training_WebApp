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
    <fmt:message bundle="${locale}" key="locale.user.label.myUserNameIs" var="myUserNameIs"/>
    <fmt:message bundle="${locale}" key="locale.user.label.enterYourPassword" var="enterYourPassword"/>
    <fmt:message bundle="${locale}" key="locale.user.label.confirmPassword" var="confirmPassword"/>
    <fmt:message bundle="${locale}" key="locale.user.label.confirmYourPassword" var="confirmYourPassword"/>
    <fmt:message bundle="${locale}" key="locale.user.label.role" var="role"/>
    <fmt:message bundle="${locale}" key="locale.user.label.enterYourRole" var="enterYourRole"/>
    <fmt:message bundle="${locale}" key="locale.user.label.singUp" var="singUp"/>
    enterYourRole

    <link rel="stylesheet" href="./css/style.css">
    <script src="../js/main.js"></script>

    <title>Register Page</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <jsp:forward page="main.jsp"/>
    </c:when>
</c:choose>
<main>
    <div class="logIn-form-box">
        <form name="RegisterForm" method="POST" action="controller" class="login-form">
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
            <input class="login-form-text"
                   type="text"
                   name="role"
                   maxlength="1"
                   pattern="[1-2]{1,}"
                   value=""
                   placeholder="${enterYourRole}"/>
            <input type="submit" value="${singUp}" class="login-form-button"/>
            <div class="login-form-message">                                     <%--TODO CHACK STYLE WRONG CREDENTIALS--%>
                <c:choose>
                    <c:when test="${not empty requestScope.wrongData}">
                        ${wrongCredentials}
                    </c:when>
                </c:choose>
            </div>
            <form/>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
