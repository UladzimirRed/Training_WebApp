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
    <fmt:message bundle="${locale}" key="locale.admin.button.changeLogin" var="changeLogin"/>
    <fmt:message bundle="${locale}" key="locale.admin.button.changeRole" var="changeRole"/>
    <fmt:message bundle="${locale}" key="locale.admin.button.changeTransport" var="changeTransport"/>
    <fmt:message bundle="${locale}" key="locale.admin.button.changeRating" var="changeRating"/>
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
        <br>
        <h2>${editUser}</h2>
        <div class="logIn-form-box-3">
            <form action="controller" name="changeLogin" method="POST">
                <input type="hidden" name="command" value="change_login_command"/>
                <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
                <span class="form-label">${login}: </span>
                <input class="login-form-text"
                       name="currentLogin"
                       value="${sessionScope.currentUser.login}">
                <input type="submit" value="${changeLogin}" class="join-us-button">
            </form>
            <form action="controller" name="changeRole" method="POST">
                <input type="hidden" name="command" value="change_role_command"/>
                <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
                <span class="form-label">${role}: </span>
                <c:choose>
                    <c:when test="${sessionScope.currentUser.role == 'COURIER'}">
                        <select class=form-dropdown name="role">
                            <option class="form-option" value="Admin">${admin}</option>
                            <option class="form-option" value="Courier" selected>${courier}</option>
                            <option class="form-option" value="Customer">${customer}</option>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <select class=form-dropdown name="role">
                            <option class="form-option" value="Admin">${admin}</option>
                            <option class="form-option" value="Courier">${courier}</option>
                            <option class="form-option" value="Customer" selected>${customer}</option>
                        </select>
                    </c:otherwise>
                </c:choose>
                <input type="submit" value="${changeRole}" class="join-us-button">
            </form>
            <form action="controller" name="changeTransport" method="POST">
                <input type="hidden" name="command" value="change_transport_command"/>
                <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
                <c:choose>
                    <c:when test="${sessionScope.currentUser.role == 'COURIER'}">
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
                            <c:otherwise>
                                <span class="form-label">${transport}: </span>
                                <select class=form-dropdown name="transport">
                                    <option class="form-option" value="Truck">${truck}</option>
                                    <option class="form-option" value="Car">${car}</option>
                                    <option class="form-option" value="None" selected>${withoutTransport}</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                        <input type="submit" value="${changeTransport}" class="join-us-button">
                    </c:when>
                </c:choose>
            </form>
            <form action="controller" name="changeRating" method="POST">
                <input type="hidden" name="command" value="change_rating_command"/>
                <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
                <c:choose>
                    <c:when test="${sessionScope.currentUser.role == 'COURIER'}">
                        <span class="form-label">${rating}: </span>
                        <input class="login-form-text"
                               name="rating"
                               value="${sessionScope.currentUser.rating}">
                        <input type="submit" value="${changeRating}" class="join-us-button">
                    </c:when>
                </c:choose>
            </form>
            <div class="horizontal-button-container">
                <form>
                    <input type="button" value="${back}" class="join-us-button" onclick="history.back()">
                </form>
            </div>
        </div>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
