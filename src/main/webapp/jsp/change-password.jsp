<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.customer.label.ifYouWantChangePass" var="ifYouWantChangePass"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.oldPass" var="oldPass"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.newPass" var="newPass"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.newPassAgain" var="newPassAgain"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.changePass" var="changePass"/>
    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>
    <fmt:message bundle="${locale}" key="locale.message.changedPassword" var="changedPassword"/>
    changedPassword
    <link rel="stylesheet" href="./css/style.css">
    <title>Change password</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div>
        <form action="controller" name="changePasswordForm" method="POST">
            <input type="hidden" name="command" value="change_password"/>
            <div>
                <br>
                <h2>${ifYouWantChangePass}</h2>
            </div>
            <div class="logIn-form-box-2">
                <p class="user-area-label">${oldPass}</p>
                <input class="login-form-password"
                       type="password"
                       name="oldPassword"
                       maxlength="32"
                       pattern="[^<>]{4,}"
                       value=""/>
                <p class="user-area-label">${newPass}</p>
                <input class="login-form-password"
                       type="password"
                       name="newPassword"
                       maxlength="32"
                       pattern="[^<>]{4,}"
                       value=""/>
                <p class="user-area-label">${newPassAgain}</p>
                <input class="login-form-password"
                       type="password"
                       name="confirmPassword"
                       maxlength="32"
                       pattern="[^<>]{4,}"
                       value=""
                       onkeyup="checkPass()"/>
                <input type="submit" value="${changePass}" class="login-form-button">
                <div>
                    <c:choose>
                        <c:when test="${not empty requestScope.wrongData}">
                            ${wrongCredentials}
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${not empty requestScope.changedPassword}">
                            ${changedPassword}
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
