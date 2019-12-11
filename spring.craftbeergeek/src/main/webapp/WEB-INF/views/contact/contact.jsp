<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Craft Bear Geek</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
    <script defer src="/webjars/font-awesome/5.10.1/js/all.min.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="../media/header.jsp"/>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Skontaktuj się z nami!
            </h1>
            <h2 class="subtitle">
                Chcesz się z nami spotkać?
                Wpadaj śmiało do naszego biura na rozmowę przy dobrym piwie albo wbijaj na naszego fanpage'a.
                Kliknij poniżej:
            </h2>
            <a href="https://www.facebook.com/">
                <img src="/pictures/facebook.png" width="100px" height="100px">
            </a>
            <a href="https://twitter.com/?lang=pl">
                <img src="/pictures/tweeter.png" width="100px" height="100px">
            </a>

        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>
