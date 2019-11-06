<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <fmt:message bundle="${locale}" key="locale.message.helloMessage" var="hello"/>
    <fmt:message bundle="${locale}" key="locale.message.welcome" var="welcome"/>
    <fmt:message bundle="${locale}" key="locale.user.label.logout" var="logout"/>

    <link rel="stylesheet" href="./css/style.css">

    <title>Welcome</title>
</head>
<body>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <jsp:forward page="/login"/>
    </c:when>
</c:choose>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<h3>${welcome}</h3>
<hr/>
${user}, ${hello}
<hr/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="logout">
    <input class="gray" type="submit" value=${logout}>
</form>
<jsp:include page="/jsp/footer.jsp"/>
</body>
</html>
