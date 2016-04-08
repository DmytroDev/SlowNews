<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/login.css">
</head>
<body>
<%@include file="global/header.jsp" %>

<div class="content-wrap">

    <div class="content-login">
        <form action="/login" method="POST">
            <h1>Log in</h1>
            <p>UserName
                <input class="username" type="text" name="username">
            </p>
            <p>Password
                <input class="password" type="password" name="password">
            </p>
            <p>
                <input class="confirm-login-button" type="submit" value="Log in">
            </p>
        </form>
        <button class="hello-button">Say Hello! (console)</button>
        <div>
            <a class="skip-authentication" href="/news">Skip authentication</a>
            <a class="new-user" href="/registration">I'm new user</a>
        </div>
    </div>

    <c:if test="${isValid==false}">

        <div class="not-valid-credentials">
            <h2 class="not-valid-msg">Your credentials aren't valid!</h2>
        </div>
    </c:if>

</div>

<%@include file="global/footer.jsp" %>
<script src="../resources/lib/jquery-2.2.3.js"></script>
<script src="../resources/js/login.js"></script>
</body>
</html>
