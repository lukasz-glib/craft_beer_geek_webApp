<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Wszystkie przepisy użytkownika</title>
</head>
<body>
<jsp:include page="../media/header.jsp"/>
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
    <c:forEach items="${ownRecipes}" var="recipe" varStatus="stat">
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
                <c:url value="/recipes/delete" var="deleteURL">
                    <c:param name="id" value="${recipe.id}"/>
                </c:url>
<%--                <c:url value="/recipes/update" var="updateURL">--%>
<%--                    <c:param name="id" value="${recipe.id}"/>--%>
<%--                </c:url>--%>
                <a class="button is-primary" href="${deleteURL}">Usuń</a>
<%--                <a class="button is-link" href="${updateURL}">Edytuj</a>--%>
            </td>

        </tr>
    </c:forEach>
    <a class="button is-success" href="/recipes/create">
        <strong>Nowy przepis</strong>
    </a>
</table>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>
