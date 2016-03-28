<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/registration.css">
</head>
<body>

<div class="header">
    <p class="header-msg">SlowNews</p>
</div>

<div class="content-wrap">

    <div class="content-registration">
        <form action="/news" method="GET">
            <h1>Registration</h1>
            UserName
            <input class="username" type="text" name="username">
            Password
            <input class="password" type="password" name="password">
            Confirm password
            <input class="confirm-password" type="password" name="confirm-password"><br>
            <input type="submit" value="Ok">
        </form>
    </div>

</div>

<div class="footer">
    <p> Copyright: "Infinity, inc.", 2016</p>
</div>

</body>
</html>
