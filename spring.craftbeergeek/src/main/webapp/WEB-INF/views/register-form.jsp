<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Craft Bear Geek</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
    <div class="columns">
        <div class="column is-one-fourth"></div>
        <div class="column is-half">
            <section class="section">
                <div class="container">
                    <div class="tile is-parent">
                        <article class="tile is-child notification is-info">
                            <p class="title">Formularz rejestracji</p>
                        </article>
                    </div>
                </div>
            </section>
        </div>
        <div class="column"></div>
    </div>
    <form:form method="post" modelAttribute="registrationData">
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="column">
            <div class="field-label is-normal">
                <label class="label">Nazwa użytkownika</label>
            </div>
            <div class="control">
                <input name="username" <form:errors path="username"/>
                        class="input is-focused" type="text" placeholder="Username">
            </div>
        </div>
        <div class="column"></div>
    </div>
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="column">
            <div class="field-label is-normal">
                <label class="label">Adres Email</label>
            </div>
            <div class="control">
                <input name="email" <form:errors path="email"/>
                        class="input is-focused" type="email" placeholder="Email">
            </div>
        </div>
        <div class="column"></div>
    </div>
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="column">
            <div class="field-label is-normal">
                <label class="label">Podaj Hasło</label>
            </div>
            <div class="control">
                <input name="password" <form:errors path="password"/>
                        class="input is-focused" type="password" placeholder="Password">
            </div>
        </div>
        <div class="column"></div>
    </div>
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="column">
            <div class="field-label is-normal">
                <label class="label">Powtórz hasło</label>
            </div>
            <div class="control">
                <input name="repassword" <form:errors path="repassword"/>
                        class="input is-focused" type="password" placeholder="Repassword">
            </div>
        </div>
        <div class="column"></div>
    </div>
    <div class="columns">
        <div class="column is-one-third"></div>
        <div class="check-box">
            <label class="checkbox">
                <input <form:errors path="termsAcceptance"/>
                        name="termsAcceptance" type="checkbox">
                Zgadzam się z <a href="#">regulaminem strony <br> i polityką prywatności</a>
            </label>
        </div>
        <div class="column"></div>
    </div>
    <div class="columns">
        <div class="column is-half"></div>
        <div class="field is-grouped">
            <div class="control">
                <button class="button is-link" type="submit">Prześlij</button>
            </div>
            <div class="control">
                <button class="button is-link is-light" type="button" formaction="/">Anuluj</button>
            </div>
        </div>
    </div>
    </form:form>
</body>
</html>
