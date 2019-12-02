<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.user.button.personalRoom" var="personalRoom"/>
    <fmt:message bundle="${locale}" key="locale.user.button.showUserList" var="showUserList"/>
    <fmt:message bundle="${locale}" key="locale.admin.text.changesAccepted" var="changesAccepted"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>Rating</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <br>
    <h2>${changesAccepted}</h2>
    <br>
    <div class="horizontal-button-container">
        <form action="admin-main">
            <input type="submit" value="${personalRoom}" class="common-button">
        </form>
        <form action="controller">
            <input type="hidden" name="command" value="show_user_list_command">
            <input type="submit" value="${showUserList}" class="common-button">
        </form>
    </div>

</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
