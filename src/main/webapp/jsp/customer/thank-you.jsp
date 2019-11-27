<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Rating</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <br>
    <h2>Спасибо, ваш голос учтён!</h2>
    <h2>Рейтинг курьера ${sessionScope.login}: ${sessionScope.userRating}</h2>
    <br>

    <form action="customer-main" class="logIn-form-box-2">
        <input type="submit" value="${personalRoom}" class="login-form-button">
    </form>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
