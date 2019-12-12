<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h1 class="title">
                Zachęcamy do aktywnego uczestnictwa w tworzeniu naszej strony. Zostań współtwórcą kraftowego świata!
            </h1>
            <h2 class="subtitle">
                Chcemy stale podnosić jakość naszej strony i wzbogacać naszą bazę o nowe informacje by dzielić się
                najlepszą wiedzą. Pomóż nam ulepszać portal. Czekamy na Twoje uwagi, sugestie i pytania.
            </h2>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="contact">
                    <div class="field">
                        <form:label path="fullName" cssClass="label">Imię i Nazwisko</form:label>
                        <div class="control has-icons-left">
                            <form:input path="fullName" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <p class="help">Set your fullname</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="email" cssClass="label">Adres Email</form:label>
                        <div class="control has-icons-left">
                            <form:input path="email" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i
                                    class="fas fa-envelope"></i></span>
                            <p class="help">Set your email</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="topic" cssClass="label">Temat zapytania</form:label>
                        <div class="control has-icons-left">
                            <form:input path="topic" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set name of your question's topic</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="description" cssClass="label">Opis zapytania</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="description" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set description of your question</p>
                        </div>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-success is-link" type="submit">Register
                            </button>
                        </div>
                        <div class="control">
                            <button class="button is-text" type="reset">Reset</button>
                        </div>
                    </div>
                    <form:errors path="*"/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>
