<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="global/header.jsp"/>
<div class="content-wrap">

    <%@include file="global/left-side-menu-light.jsp"%>
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
