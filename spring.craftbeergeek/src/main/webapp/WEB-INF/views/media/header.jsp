<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Strona główna
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>

                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            Więcej
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item" href="/contact">
                                Kontakt
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <sec:authorize access="isAnonymous()">
                                <a class="button is-primary" href="/register">
                                    <strong>Zarejestruj</strong>
                                </a>
                                <a class="button is-success" href="/login">
                                    <strong>Zaloguj</strong>
                                </a>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <a class="button is-primary" href="/recipes">
                                    <strong>Wszystkie przepisy</strong>
                                </a>
                                <a class="button is-success" href="/recipes/own-recipes">
                                    <strong>Moje przepisy</strong>
                                </a>
                                <a class="button is-primary" href="/user">
                                    <strong>Twoje konto</strong>
                                </a>
                                <form method="post" action="/logout">
                                    <button class="button is-link" type="submit">Wyloguj</button>
                                    <sec:csrfInput/>
                                </form>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
