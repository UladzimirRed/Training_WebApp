<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Courier Exchange</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div class="navigation-bar">
        <form action="customer/customer-area.jsp">
            <input type="submit" value="personal area" class="common-button">
        </form>
        <form action="customer-balance.jsp">
            <input type="submit" value="My balance" class="common-button">
        </form>
        <form action="customer-delivery.jsp">
            <input type="submit" value="My delivery" class="common-button">
        </form>
        <form action="new-order.jsp">
            <input type="submit" value="New order" class="common-button">
        </form>
        <form action="rates.jsp">
            <input type="submit" value="New order" class="common-button">
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
