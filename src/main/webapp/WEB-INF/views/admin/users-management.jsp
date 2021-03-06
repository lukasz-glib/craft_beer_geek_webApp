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
        <th>Nazwa użytkownika</th>
        <th>Data zarejestrowania</th>
        <th>Status: czy aktywny</th>

    </tr>
    <c:forEach items="${allUsers}" var="user" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${user.username}</td>
            <td>${user.addedDateUser}</td>
            <td>${user.active}</td>
            <td>
                <c:url value="/admin" var="returnURL"></c:url>
                <a class="button is-link" href="${returnURL}">Powrót</a>
                <c:url value="/admin/delete" var="deleteURL">
                    <c:param name="id" value="${user.id}"/>
                </c:url>
                <a class="button is-primary" href="${deleteURL}">Usuń</a>
                <c:url value="/admin/active" var="activeURL">
                    <c:param name="id" value="${user.id}"/>
                </c:url>
                <a class="button is-grouped-multiline" href="${activeURL}">Odblokuj użytkownika</a>
                <c:url value="/admin/blocked" var="blockedURL">
                    <c:param name="id" value="${user.id}"/>
                </c:url>
                <a class="button is-danger" href="${blockedURL}">Zablokuj użytkownika</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>
