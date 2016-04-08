<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/show-users.css">

</head>
<body>

<%@include file="global/header.jsp"%>

<div class="content-wrap">

    <%@include file="global/left-side-menu.jsp"%>
    <div class="users-content">
        <h2>List of users:</h2>
        <ol>
            <c:forEach items="${users}" var="user">
                <li>
                    <p class="user-item">${user.login}</p>
                </li>
            </c:forEach>
        </ol>
    </div>
</div>

<%@include file="global/footer.jsp"%>
<script src="../resources/lib/jquery-2.2.3.js"></script>
<script src="../resources/js/show-users.js"></script>
</body>
</html>
