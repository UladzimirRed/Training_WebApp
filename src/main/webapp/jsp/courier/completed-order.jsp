<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.courier.text.completedOrders" var="completedOrders"/>
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
    <title>Completed orders</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <div class="table-container-head">
        <h2>${completedOrders}</h2>
        <br>
        <table class="head-table">
            <tr>
                <th>${orderId}</th>
                <th>${subject}</th>
                <th>${customerName}</th>
                <th>${distance}</th>
                <th>${price}</th>
                <th>${rate}</th>
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
                    <td>${order.distance}</td>
                    <td>${order.totalPrice}</td>
                        <%--                        fixme add local to rate delivery--%>
                    <td>${order.rate}</td>
                        <%--                        <c:when test="${order.rate == 'true'}">--%>
                        <%--                        <td>${yes}</td></c:when>--%>
                        <%--                        <c:otherwise><td>${no}</td></c:otherwise>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form action="courier-main" class="center-button-container">
        <input class="join-us-button" type="submit" value="${personalRoom}">
    </form>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>

