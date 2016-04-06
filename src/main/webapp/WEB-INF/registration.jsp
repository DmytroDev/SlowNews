<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/registration.css">
</head>
<body>
<%@include file="global/header.jsp"%>

<div class="content-wrap">

    <div class="content-registration">
        <form action="/registration" method="POST">
            <h1>Registration</h1>
            <p>
                UserName<input class="username" type="text" name="username">
            </p>
            <p>
                Password<input class="password" type="password" name="password">
            </p>
            <p>
                Confirm password<input class="confirm-password" type="password" name="confirm-password">
            </p>
            <p>
                <input class="confirm-registration-button" type="submit" value="Ok">
            </p>

        </form>
    </div>

    <c:if test="${error==true}">
        <div class="error">
            <h2 class="error">Your registration data are empty or incorrect!</h2>
        </div>
    </c:if>
</div>

<%@include file="global/footer.jsp"%>
</body>
</html>
