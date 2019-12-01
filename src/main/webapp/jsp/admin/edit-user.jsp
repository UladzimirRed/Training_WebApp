<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.admin.text.editUser" var="editUser"/>
    <fmt:message bundle="${locale}" key="locale.admin.label.userId" var="userId"/>
    <fmt:message bundle="${locale}" key="locale.admin.label.login" var="login"/>
    <fmt:message bundle="${locale}" key="locale.admin.label.role" var="role"/>
    <fmt:message bundle="${locale}" key="locale.admin.label.transport" var="transport"/>
    <fmt:message bundle="${locale}" key="locale.admin.label.rating" var="rating"/>
    <fmt:message bundle="${locale}" key="locale.admin.text.admin" var="admin"/>
    <fmt:message bundle="${locale}" key="locale.admin.text.courier" var="courier"/>
    <fmt:message bundle="${locale}" key="locale.admin.text.customer" var="customer"/>
    <fmt:message bundle="${locale}" key="locale.admin.button.changeUser" var="changeUser"/>
    <fmt:message bundle="${locale}" key="locale.user.text.truck" var="truck"/>
    <fmt:message bundle="${locale}" key="locale.user.text.car" var="car"/>
    <fmt:message bundle="${locale}" key="locale.user.text.withoutTransport" var="withoutTransport"/>
    <fmt:message bundle="${locale}" key="locale.user.button.back" var="back"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Edit user</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <div>
        <form action="controller" name="confirmChange" method="POST">
            <input type="hidden" name="command" value="confirm_change_command"/>
            <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
            <br>
            <h2>${editUser}</h2>
            <div class="logIn-form-box-3">
                <span class="form-label">${login}: </span>
                <input class="login-form-text"
                       name="currentLogin"
                       value="${sessionScope.currentUser.login}">
                <span class="form-label">${role}: </span>
                <c:choose>
                    <c:when test="${sessionScope.currentUser.role == 'COURIER'}">
                        <select class=form-dropdown name="role">
                            <option class="form-option" value="Admin">${admin}</option>
                            <option class="form-option" value="Courier" selected>${courier}</option>
                            <option class="form-option" value="Customer">${customer}</option>
                        </select>
                        <c:choose>
                            <c:when test="${sessionScope.currentUser.transport == 'TRUCK'}">
                                <span class="form-label">${transport}: </span>
                                <select class=form-dropdown name="transport">
                                    <option class="form-option" value="Truck" selected>${truck}</option>
                                    <option class="form-option" value="Car">${car}</option>
                                    <option class="form-option" value="None">${withoutTransport}</option>
                                </select>
                            </c:when>
                            <c:when test="${sessionScope.currentUser.transport == 'CAR'}">
                                <span class="form-label">${transport}: </span>
                                <select class=form-dropdown name="transport">
                                    <option class="form-option" value="Truck">${truck}</option>
                                    <option class="form-option" value="Car" selected>${car}</option>
                                    <option class="form-option" value="None">${withoutTransport}</option>
                                </select>
                            </c:when>
                            <c:when test="${sessionScope.currentUser.transport == 'NONE'}">
                                <span class="form-label">${transport}: </span>
                                <select class=form-dropdown name="transport">
                                    <option class="form-option" value="Truck">${truck}</option>
                                    <option class="form-option" value="Car" >${car}</option>
                                    <option class="form-option" value="None" selected>${withoutTransport}</option>
                                </select>
                            </c:when>
                        </c:choose>
                        <span class="form-label">${rating}: </span>
                        <input class="login-form-text"
                               name="rating"
                               value="${sessionScope.currentUser.rating}">
                    </c:when>
                    <c:otherwise>
                        <select class=form-dropdown name="role">
                            <option class="form-option" value="Admin">${admin}</option>
                            <option class="form-option" value="Courier">${courier}</option>
                            <option class="form-option" value="Customer" selected>${customer}</option>
                        </select>
                    </c:otherwise>
                </c:choose>
                <div class="horizontal-button-container">
                    <form>
                        <input type="button" value="${back}" class="join-us-button" onclick="history.back()">
                    </form>
                    <input type="submit" value="${changeUser}" class="join-us-button">
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
