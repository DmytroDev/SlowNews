<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <img class="header-left-part" src="../resources/images/logo1.jpg" alt="logo">
    <div>
        <input class="logout-button" type="button" value="log out" onclick="window.location='/logout'">
    </div>
    <div class="header-right-part">
        Добро пожаловать,
        <c:if test="${empty username}">
            guest
        </c:if>
        <c:if test="${not empty username}">
            ${username}
        </c:if>

    </div>

</div>
