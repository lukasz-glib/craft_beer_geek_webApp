<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Craft Bear Geek</title>
    <%-- Elementy dotyczące treści strony --%>


    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="media/header.jsp"/>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Craft Bear Geek
            </h1>
            <h2 class="subtitle">
                Witaj na stronie <strong>Miłośników piwa craftowego !</strong>.
                <br/>Lubisz napić się dobrego piwa kraftowego? Lubisz nowe wyzwania i chcesz nauczyć się sam ważyć piwo?
                A może chcesz zrobić dobre wrażenie na znajomych? Postaramy się o to, aby Twoja wiedza była pełna
                i wartościowa. Na naszej stronie znajdziesz wiele przepisów ważenia piwa rzemieśliniczego w różnych
                stylach oraz aktualności i nadchodzące wydarzenia w branży piwowarskiej.
            </h2>

        </div>
    </div>
</section>
<jsp:include page="media/footer.jsp"/>
</body>
</html>
