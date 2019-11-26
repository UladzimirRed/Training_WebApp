<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>


    <fmt:message bundle="${locale}" key="locale.user.text.truck" var="truck"/>
    <fmt:message bundle="${locale}" key="locale.user.text.car" var="car"/>
    <fmt:message bundle="${locale}" key="locale.user.text.withoutTransport" var="withoutTransport"/>
    <fmt:message bundle="${locale}" key="locale.user.label.distance" var="distance"/>
    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.newOrder" var="newOrder"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.express" var="express"/>
    <fmt:message bundle="${locale}" key="locale.customer.text.regular" var="regular"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.subjectOfTransportation" var="subjectOfTransportation"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.transportForCargo" var="transportForCargo"/>
    <fmt:message bundle="${locale}" key="locale.customer.label.rate" var="rate"/>
    <fmt:message bundle="${locale}" key="locale.customer.button.next" var="next"/>


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
            <input type="hidden" name="command" value="confirm_order_command"/>
            <input type="hidden" name="command" value="refresh_order_command">
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
                    <option class="form-option" value="Truck">${truck}</option>
                    <option class="form-option" value="Car">${car}</option>
                    <option class="form-option" value="None">${withoutTransport}</option>
                </select>
                <br>
                <label class="form-label">
                    <input type="checkbox" name="rate" value="true">${rate}
                </label>
                <br>
                <span class="form-label">${distance}</span>
                <input class="login-form-text"
                       type="number"
                       name="distance"
                       value=""
                       placeholder="Enter the number of km from 1 to 1000"
                       min="1"
                       max="1000"
                       required>
                <input type="submit" value="${next}" class="login-form-button">
            </div>
        </form>
        <form action="customer-main" class="logIn-form-box-2">
            <input  type="submit" value="${personalRoom}" class="login-form-button">
        </form>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
