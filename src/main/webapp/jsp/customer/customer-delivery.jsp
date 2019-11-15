<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale.locale" var="locale"/>

    <link rel="stylesheet" href="./css/style.css">
    <title>My delivery</title>
</head>
<body>
<header>
    <jsp:include page="/jsp/header.jsp"/>
</header>
<main class="main">
    <div class="table-container-head">
        <h2>Delivery</h2>
        <table class="head-table">
            <tr>
                <th># acc</th>
                <th>courier name</th>
                <th>price</th>
                <th>status</th>
            </tr>
        </table>
    </div>
    <div class="table-container-body">
        <table class="body-table">
            <tr>
                <td>user1</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user3</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
            <tr>
                <td>user2</td>
                <td>courier2</td>
                <td>10$</td>
                <td>in progress</td>
            </tr>
        </table>
    </div>
</main>
<footer>
    <jsp:include page="/jsp/footer.jsp"/>
</footer>
</body>
</html>
