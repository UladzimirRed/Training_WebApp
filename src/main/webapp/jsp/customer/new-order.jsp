<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>


    <fmt:message bundle="${locale}" key="locale.user.text.truck" var="truck"/>
    <fmt:message bundle="${locale}" key="locale.user.text.car" var="car"/>
    <fmt:message bundle="${locale}" key="locale.user.text.withoutTransport" var="withoutTransport"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.newOrder" var="newOrder"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.express" var="express"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.regular" var="regular"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.subjectOfTransportation" var="subjectOfTransportation"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.transportForCargo" var="transportForCargo"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.rate" var="rate"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.orderTransportation" var="orderTransportation"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>New Order</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div>
        <form action="controller" name="newOrder" method="POST">
            <input type="hidden" name="command" value="new_order_command"/>
            <input type="hidden" name="command" value="count_cost">
            <div>
                <br>
                <h2>${newOrder}</h2>
            </div>
            <div class="logIn-form-box-2">
                <span class="form-label">${subjectOfTransportation}</span>
                <input class="login-form-text"
                       type="text"
                       name="subject">
                <span class="form-label">${transportForCargo}</span>
                <select class=form-dropdown name="transport">
                    <option class="form-option">${truck}</option>
                    <option class="form-option">${car}</option>
                    <option class="form-option">${withoutTransport}</option>
                </select>
                <span class="form-label">${rate}</span>
                <select class=form-dropdown name="rate">
                    <option class="form-option">${express}</option>
                    <option class="form-option">${regular}</option>
                </select>
                <span class="form-label">Distance</span>
                <input class="login-form-text"
                       type="number"
                       name="distance"
                       value=""
                       placeholder="enter the number of km from 1 to 1000"
                       min="1"
                       max="1000">
                <span class="form-label">Total cost</span>
                <input class="login-form-text"
                       type="text"
                       name="total"
                       value="${sessionScope.order.totalPrice}">
                <input type="submit" value="count cost" class="login-form-button">
                <input type="submit" value="${orderTransportation}" class="login-form-button">
                <div>
                    <c:choose>
                        <c:when test="${not empty requestScope.wrongData}">
                            ${wrongCredentials}
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </form>
    </div>

</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
