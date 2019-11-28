<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.customer.text.rateDelivery" var="rateDelivery"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.orderId" var="orderId"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.courierName" var="courierName"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.price" var="price"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.status" var="status"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.distance" var="distance"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.rate" var="rate"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.transport" var="transport"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.subject" var="subject"/>
    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.refresh" var="refresh"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Rate delivery</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main>
    <div class="main-form">
        <div class="table-container-head">
            <h2>${rateDelivery}</h2>
            <br>
            <table class="head-table">
                <tr>
                    <th>${orderId}</th>
                    <th>${subject}</th>
                    <th>${courierName}</th>
                    <th>${price}</th>
                    <th>${distance}</th>
                    <th>${rate}</th>
                    <th>${transport}</th>
                    <th>${status}</th>
                </tr>
            </table>
        </div>
        <form action="controller" name="refreshOrder" method="POST">
        <div class="table-current-container-body" >
            <table class="body-table">
                <tr>
                    <td>${sessionScope.order.orderId}</td>
                    <td>${sessionScope.order.subject}</td>
                    <td>${sessionScope.order.user.login}</td>
                    <td>${sessionScope.order.totalPrice} BYN</td>
                    <td>${sessionScope.order.distance} km</td>
                    <td>${sessionScope.order.rate}</td>
                    <td>${sessionScope.order.transport}</td>
                    <td>${sessionScope.order.status}</td>
                </tr>
            </table>
        </div>
        <span class="form-label">RATING:</span>
        <select class=form-dropdown name="rate">
                <option value="5">5</option>
                <option value="4">4</option>
                <option value="3">3</option>
                <option value="2">2</option>
                <option value="1">1</option>
        </select>
            <input type="hidden" name="command" value="confirm_rate_command">
            <input type="submit" value="${rateDelivery}" class="join-us-button">
        </form>
        <br>
        <br>
        <div class="horizontal-button-container">
            <form action="customer-main">
                <input class="join-us-button" type="submit" value="${personalRoom}">
            </form>
        </div>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
