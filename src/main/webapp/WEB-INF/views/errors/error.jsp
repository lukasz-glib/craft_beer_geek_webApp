<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<body class="has-navbar-fixed-top">
<header>
    <jsp:include page="/WEB-INF/views/media/header.jsp"/>
</header>
<section class="section">
    <div class="container">
        <h1 class="title is-danger">
            <strong>Ups...</strong> coś poszło nie tak :(
        </h1>
        <h2 class="subtitle is-danger">
            Gdybyś potrzebował wskazówki, to:
        </h2>
        <div class="content">
            <p><i>${exception.message}<i/></p>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="content">
                <c:if test="${stackTrace != null}">
                    <pre>${stackTrace}</pre>
                </c:if>
            </div>
        </sec:authorize>
    </div>
</section>
<footer class="footer">
    <jsp:include page="/WEB-INF/views/media/footer.jsp"/>
</footer>
</body>
</html>
