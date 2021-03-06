<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All new user's craft beer recipe</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.10.1/js/all.min.js"></script>
</head>
<body class = "has-navbar-fixed-top">
    <jsp:include page="../media/header.jsp"/>
    <table>
        <tr>
            <th></th>
        </tr>
    </table>
    <table>
        <tr>
            <th>Lp.</th>
            <th>Nazwa piwa</th>
            <th>Słody</th>
            <th>Chmiel</th>
            <th>Zacieranie</th>
            <th>Gotowanie</th>
            <th>Fermentacja</th>
            <th>Butelkowanie</th>
        </tr>
        <c:forEach items="${recipes}" var="recipe" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${recipe.nameBeer}</td>
                <td>${recipe.malt}</td>
                <td>${recipe.hop}</td>
                <td>${recipe.mashing}</td>
                <td>${recipe.boiling}</td>
                <td>${recipe.fermentation}</td>
                <td>${recipe.bottling}</td>
                <td>
                    <c:url value="/user" var="returnURL"></c:url>
                    <a href="${returnURL}">Powrót</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../media/footer.jsp"/>
</body>
</html>
