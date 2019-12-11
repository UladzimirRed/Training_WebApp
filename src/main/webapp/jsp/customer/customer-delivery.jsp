<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.customer.text.myDelivery" var="myDelivery"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.orderId" var="orderId"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.courierName" var="courierName"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.price" var="price"/>
    <fmt:message bundle="${locale}" key="locale.customer.table.status" var="status"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.subject" var="subject"/>
    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.refresh" var="refresh"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.rateCompletedOrders" var="rateCompletedOrders"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>My delivery</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <br>
    <h2>${myDelivery}</h2>
    <div class="table-container-head">
        <table class="head-table">
            <tr>
                <th>${orderId}</th>
                <th>${subject}</th>
                <th>${courierName}</th>
                <th>${price}</th>
                <th>${status}</th>
            </tr>
        </table>
    </div>
    <div class="table-container-body">
        <table class="body-table">
            <c:forEach var="order" items="${sessionScope.orders}" varStatus="status">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.subject}</td>
                    <td>${order.user.login}</td>
                    <td>${order.totalPrice}</td>
                    <td>${order.status}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="horizontal-button-container">
        <div style="width: 25%">
            <form action="controller" name="refreshOrder" method="GET">
                <input type="hidden" name="command" value="show_active_order_command">
                <input type="submit" value="${refresh}" class="join-us-button">
            </form>
        </div>
        <div style="width: 25%">
            <form action="customer-main">
                <input class="join-us-button" type="submit" value="${personalRoom}">
            </form>
        </div>
        <div style="width: 25%">
            <form action="controller" name="doneOrder" method="GET">
                <input type="hidden" name="command" value="show_done_order_command">
                <input type="submit" value="${rateCompletedOrders}" class="join-us-button">
            </form>
        </div>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
