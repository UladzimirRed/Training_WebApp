<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.text.listOfUsers" var="listOfUsers"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.orderId" var="orderId"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.courierName" var="courierName"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.customerName" var="customerName"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.price" var="price"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.status" var="status"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.subject" var="subject"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.rate" var="rate"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.take" var="take"/>
    <fmt:message bundle="${locale}" key="locale.user.label.distance" var="distance"/>
    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>
    <fmt:message bundle="${locale}" key="locale.user.button.back" var="back"/>
    <fmt:message bundle="${locale}" key="locale.user.text.yes" var="yes"/>
    <fmt:message bundle="${locale}" key="locale.user.text.no" var="no"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>List of users</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <div class="table-container-head">
        <h2>${listOfUsers}</h2>
        <br>
        <table class="head-table">
            <tr>
                <th>USER ID</th>
                <th>USER LOGIN</th>
                <th>ROLE</th>
                <th>TRANSPORT</th>
                <th>RATING</th>
                <th>EDIT</th>
            </tr>
        </table>
    </div>
    <div class="table-container-body">
        <table class="body-table">
            <c:forEach var="user" items="${sessionScope.users}" varStatus="status">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.role}</td>
                    <td>${user.transport}</td>
                    <td>${user.rating}</td>
                    <td>
                        <form action="controller">
                            <input type="hidden" name="command" value="edit_user_command">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="submit" value="V" class="lang-button">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="admin-main" class="center-button-container">
        <input class="join-us-button" type="submit" value="${personalRoom}">
    </form>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
