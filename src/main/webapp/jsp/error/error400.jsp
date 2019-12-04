<%@ page isErrorPage="true" isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main-form">
    <br>
    <h2>ERROR 400 BAD REQ</h2>
    <form action="home">
        <input type="submit" value="HOME" class="common-button">
    </form>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
