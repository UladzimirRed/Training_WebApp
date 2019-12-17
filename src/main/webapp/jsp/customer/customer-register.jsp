<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>
    <fmt:message bundle="${locale}" key="locale.message.passwordDoesNotMatch" var="passwordDoesNotMatch"/>
    <fmt:message bundle="${locale}" key="locale.message.userExist" var="userExist"/>
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
    <fmt:message bundle="${locale}" key="locale.user.title.loginRegex" var="loginRegex"/>
    <fmt:message bundle="${locale}" key="locale.user.title.passwordRegex" var="passwordRegex"/>

    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/main.js"></script>
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
    <div class="logIn-form-box">
        <form name="RegisterForm" method="POST" action="controller" class="login-form">
            <input type="hidden" name="command" value="register"/>
            <input type="hidden" name="role" value="customer"/>
            <span class="form-label">${login} *</span>
            <input class="login-form-text"
                   type="text"
                   name="login"
                   maxlength="16"
                   pattern="^[\w_]{4,16}$"
                   title="${loginRegex}"
                   value=""
                   placeholder="${myUserNameIs}"
                   required/>
            <span class="form-label">${password} *</span>
            <input class="login-form-password"
                   id="pass1"
                   type="password"
                   name="password"
                   maxlength="32"
                   pattern="^[\w_]{4,32}$"
                   title="${passwordRegex}"
                   value=""
                   placeholder="${enterYourPassword}"
                   required/>
            <span class="form-label">${confirmPassword} *</span>
            <input class="login-form-password"
                   id="pass2"
                   type="password"
                   name="confirmPassword"
                   maxlength="32"
                   pattern="^[\w_]{4,32}$"
                   title="${passwordRegex}"
                   value=""
                   onkeyup="checkPass()"
                   placeholder="${confirmYourPassword}"
                   required/>
            <input type="submit" value="${signUp}" class="login-form-button"/>
            <div class="login-form-message">
                <c:choose>
                    <c:when test="${not empty requestScope.wrongData}">
                        ${wrongCredentials}
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${not empty requestScope.passwordDoesNotMatch}">
                        ${passwordDoesNotMatch}
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${not empty requestScope.userExist}">
                        ${userExist}
                    </c:when>
                </c:choose>
            </div>
        </form>
    </div>
    <c:if test="${sessionScope.user.role != 'CUSTOMER'}">
        <jsp:forward page="/jsp/error/illegal-access-error.jsp"/>
    </c:if>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
