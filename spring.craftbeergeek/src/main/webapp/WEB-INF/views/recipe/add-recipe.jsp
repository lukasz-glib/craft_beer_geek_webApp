<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adding new user's craft beer recipe</title>
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
                Dodawanie nowego przepisu na piwo craftowe
            </h1>
            <h2 class="subtitle">
                Podziel się z innymi nowym przepisem warzenia piwa !
            </h2>
        </div>
    </div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="recipe">
                    <div class="field">
                        <form:label path="nameBeer" cssClass="label">Nazwa piwa</form:label>
                        <div class="control has-icons-left">
                            <form:input path="nameBeer" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                            <p class="help">Set name of your beer</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="malt" cssClass="label">Słody</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="malt" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i
                                    class="fas fa-envelope"></i></span>
                            <p class="help">Set all malts which are using in brewing</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="hop" cssClass="label">Chmiele</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="hop" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set all hops which are using in brewing</p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="mashing" cssClass="label">Zacieranie</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="mashing" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set description relating to mashing </p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="boiling" cssClass="label">Gotowanie</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="boiling" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set description relating to boiling </p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="fermentation" cssClass="label">Fermentacja</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="fermentation" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set description relating to fermentation </p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="bottling" cssClass="label">Butelkowanie</form:label>
                        <div class="control has-icons-left">
                            <form:textarea style="margin: 0px; width: 450px; height: 200px"
                                           path="bottling" cssClass="text-area" required="true"/>
                            <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                            <p class="help">Set description relating to bottling </p>
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
