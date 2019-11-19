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

    <link rel="stylesheet" href="./css/style.css">
    <title>My delivery</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div class="table-container-head">
        <h2>${myDelivery}</h2>
        <br>
        <table class="head-table">
            <tr>
                <th>${orderId}</th>
                <th>ПРЕДМЕТ</th>
                <th>${courierName}</th>
                <th>${price}</th>
                <th>${status}</th>
            </tr>
        </table>
    </div>
    <div class="table-container-body">
        <table class="body-table">

                <tr>
                    <td>${sessionScope.order.order_id}</td>
                    <td>${sessionScope.order.subject}</td>
                    <td>${sessionScope.order.user.login}</td>
                    <td>${sessionScope.order.totalPrice}</td>
                    <td>${sessionScope.order.status}</td>
                </tr>


            <tr>

            </tr>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user3</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>user2</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>userLast</td>--%>
<%--                <td>courier2</td>--%>
<%--                <td>10$</td>--%>
<%--                <td>in progress</td>--%>
<%--            </tr>--%>
        </table>
    </div>
    <form action="controller" name="newOrder" method="POST">
        <input type="hidden" name="command" value="refresh_delivery_command">
    <input type="submit" value="refresh" class="login-form-button">
    </form>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
