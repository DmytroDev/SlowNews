<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/login.css">
</head>
<body>
<div class="header">
    <p class="header-msg">SlowNews</p>
</div>

<div class="content-wrap">

    <div class="content-login">
        <form action="/news" method="GET">
            <h1>Log in</h1>
            UserName
            <input class="username" type="text" name="username">
            Password
            <input class="password" type="password" name="password"><br>
            <input type="submit" value="Ok">
        </form>
        <div class="new-user">
            <a href="/registration">I'm new user</a>
        </div>
    </div>

</div>

<div class="footer">
    <p> Copyright: "Infinity, inc.", 2016</p>
</div>

</body>
</html>
