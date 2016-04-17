<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="global/header.jsp"/>

<div class="content-wrap">
    <div class="content-login">
        <form id="login-form" action="/login" method="POST">
            <h1>Log in</h1>
            <p>UserName
                <input class="username" type="text" name="username">
            </p>
            <p>Password
                <input class="password" type="password" name="password">
            </p>
            <p>
                <input id="confirm-login-button" type="submit" value="Log in">
            </p>
        </form>
        <button id="update-button">Update weather forecast</button>
        <div>
            <a id="skip-authentication" href="/news">Skip authentication</a>
            <a id="new-user" href="/registration">I'm new user</a>
        </div>
    </div>

    <c:if test="${isValid==false}">
        <div class="not-valid-credentials">
            <h2 class="not-valid-msg">Your credentials aren't valid!</h2>
        </div>
    </c:if>
</div>
