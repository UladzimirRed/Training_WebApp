<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.helloMessage" var="hello"/>
    <fmt:message bundle="${locale}" key="locale.message.welcome" var="welcome"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.personalArea" var="personalArea"/>
    <fmt:message bundle="${locale}" key="locale.courier.button.takeOrder" var="takeOrder"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.newOrder" var="newOrder"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.rates" var="rates"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.myDelivery" var="myDelivery"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Welcome</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div>
        <br>
        <p>${welcome}, ${sessionScope.user.login}</p>
    </div>
    <div class="navigation-bar">
        <form action="courier-area">
            <input type="submit" value="${personalArea}" class="common-button">
        </form>
        <form action="controller">
            <input type="hidden" name="command" value="show_available_command">
            <input type="submit" value="${takeOrder}" class="common-button">
        </form>
<%--        <form action="controller" name="myDeliveryForm" method="POST">--%>
<%--            <input type="hidden" name="command" value="refresh_delivery_command">--%>
<%--            <input type="submit" value="${myDelivery}" class="common-button">--%>
<%--        </form>--%>
<%--        <form action="rate">--%>
<%--            <input type="submit" value="${rates}" class="common-button">--%>
<%--        </form>--%>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
