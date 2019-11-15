<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.customer.text.newOrder" var="newOrder"/>

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
            <input type="hidden" name="command" value="new-order"/>
            <div>
                <br>
                <h2>${newOrder}</h2>
            </div>
            <div class="logIn-form-box-2">
                <span class="form-label">Что везём?:</span>
                <input class="login-form-text"
                       type="text">
                <p class="user-area-label">Вид перевозки</p>
                <label class="checkbox-container">Truck
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <label class="checkbox-container">Car
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <label class="checkbox-container">Legs
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <p class="user-area-label">Вес содержимого</p>
                <label class="checkbox-container">1-5
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <label class="checkbox-container">5-50
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <label class="checkbox-container">50-1000
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <p class="user-area-label">Тариф</p>
                <label class="checkbox-container">Экспресс
                    <input type="checkbox" checked="checked">
                    <span class="checkmark"></span>
                </label>
                <label class="checkbox-container">Эконом
                    <input type="checkbox">
                    <span class="checkmark"></span>
                </label>
                <input type="submit" value="Заказать перевозку" class="login-form-button">
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
