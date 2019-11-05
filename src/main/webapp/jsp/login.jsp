<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.wrongCredentials" var="wrongCredentials"/>

    <fmt:message bundle="${locale}" key="locale.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.label.password" var="password"/>
    <fmt:message bundle="${locale}" key="locale.label.log_in" var="log_in"/>
    <fmt:message bundle="${locale}" key="locale.label.myUserNameIs" var="myUserNameIs"/>
    <fmt:message bundle="${locale}" key="locale.label.enterYourPassword" var="enterYourPassword"/>

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
<div class="LoginFormBox">
    <form name="LoginForm" method="POST" action="controller" class="LoginForm">
        <input type="hidden" name="command" value="login"/>
        <span class="FormLabel">${login}:</span>
        <input type="text"
               name="login"
               value=""
               class="LoginFormText"
               placeholder="${myUserNameIs}"/>
        <span class="FormLabel">${password}:</span>
        <input type="password"
               name="password"
               value=""
               class="LoginFormPassword"
               placeholder="${enterYourPassword}"/>
        ${errorLoginPassMessage}
        ${wrongAction}
        ${nullPage}
        <input type="submit" value="${log_in}" class="LoginFormButton"/>
        <c:choose>                                                           <%--TODO STYLE TO WRONG CREDENTIALS--%>
        <c:when test="${not empty requestScope.wrongData}">
            ${wrongCredentials}
        </c:when>
        </c:choose>
    <form/>
</div>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>                                    <%--TODO STYLE TO WRONG FOOTER--%>
</footer>
</body>
</html>
