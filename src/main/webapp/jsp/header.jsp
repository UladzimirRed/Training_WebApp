<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.lang.text.english" var="en"/>
    <fmt:message bundle="${locale}" key="locale.lang.text.russian" var="ru"/>
    <fmt:message bundle="${locale}" key="locale.user.label.signIn" var="signIn"/>


    <link rel="stylesheet" href="./css/style.css">
    <title>Header</title>
</head>
<body>
<div class="Header">
    <form action="controller">
        <input type="hidden" name="command" value="home"/>
        <div class="logo">
            <input type="image" src="./assets/logo.png" alt="#" width="350" height="100">
        </div>
    </form>
    <div class="sing-box">
        <div class="lang-button-box">
            <form action="controller">
                <input type="hidden" name="command" value="locale"/>
                <input class="lang-button" type="submit" name="lang" value=${en}>
            </form>
            <form action="controller">
                <input type="hidden" name="command" value="locale"/>
                <input class="lang-button" type="submit" name="lang" value=${ru}>
            </form>
        </div>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <form action="login">
                    <input class="singIn-button" type="submit" value="${signIn}">
                </form>
            </c:when>
            <c:otherwise>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="logout">
                    <input class="singIn-button" type="submit" value="SignOut">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
