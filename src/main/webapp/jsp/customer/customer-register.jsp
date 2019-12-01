<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>
    <fmt:message bundle="${locale}" key="locale.user.text.register" var="register"/>

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
    <script src="../js/main.js"></script>

    <title>Register Page</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <jsp:forward page="customer-main.jsp"/>
    </c:when>
</c:choose>
<main class="main-form">
    <div>
        <br/>
        <h2>${register}</h2>
    </div>
    <div class="logIn-form-box-2">
        <form name="RegisterForm" method="POST" action="controller" class="login-form">
            <input type="hidden" name="command" value="register"/>
            <input type="hidden" name="role" value="customer"/>
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
<%--            <span class="form-label">${role}</span>--%>
<%--            <select class=form-dropdown name="role">--%>
<%--                <option class="form-option">${customer}</option>--%>
<%--                <option class="form-option">${courier}</option>--%>
<%--            </select>--%>
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
