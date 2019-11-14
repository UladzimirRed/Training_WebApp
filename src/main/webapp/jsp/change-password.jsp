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

    <link rel="stylesheet" href="./css/style.css">
    <title>Change password</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div class="change-pass-form-box">
        <form action="controller">
            <div>
                <br>
                <span>${ifYouWantChangePass}</span>
            </div>
            <input type="hidden" name="command" value="changePass"/>
            <span>${oldPass}</span>
            <input type="password"
                   maxlength="32"
                   pattern="[^<>]{4,}"
                   value=""/>
            <span>${newPass}</span>
            <input type="password"
                   maxlength="32"
                   pattern="[^<>]{4,}"
                   value=""/>
            <span>${newPassAgain}</span>
            <input type="password"
                   maxlength="32"
                   pattern="[^<>]{4,}"
                   value=""
                   onkeyup="checkPass()"/>
            <input type="submit" value="${changePass}">
            <div>
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
