<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/show-users.css">
</head>
<body>

<div class="header">
    <p class="header-msg">SlowNews</p>
</div>

<div class="content-wrap">

    <div class="left-menu">
        <ol class="list">
            <li class="news-item">
                <a href="/news">News</a>
            </li>
            <li class="archive-item">
                <a href="/archive">Archive</a>
            </li>
            <li class="archive-item">
                <a href="/show">Show users</a>
            </li>

        </ol>
    </div>
    <div class="users-content">
        <h2>List of users:</h2>
        <ol>
            <c:forEach items="${users}" var="user">
                <li>
                    <p>${user.login}</p>
                </li>
            </c:forEach>
        </ol>
    </div>
</div>

<div class="footer">
    <p> Copyright: "Infinity, inc.", 2016</p>
</div>
</body>
</html>
