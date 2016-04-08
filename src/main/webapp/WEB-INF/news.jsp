<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>News</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/news_archive.css">
</head>
<body>

<%@include file="global/header.jsp" %>

<div class="content-wrap">

    <%@include file="global/left-side-menu.jsp" %>
    <div class="content">
        <c:forEach items="${newsList}" var="news">
            <div class="content-concrete-news">

                <div class="image-content">
                    <img class="news-picture" src="${news.enclosure.url}" alt="Image">
                    <%--<img class="news-picture" src="/resources/images/1.jpg" alt="Image">--%>
                </div>
                <div class="news-content">
                    <div class="news-title">
                        <h2>${news.title}</h2>
                    </div>
                    <div class="news-data">
                        <p>${news.description}</p>
                    </div>
                    <c:if test="${username!=guest}">
                        <form action="/news" class="form-add-archive" method="post">
                            <%--<input type="hidden" name="imagePath" value="${news.imagePath}">--%>
                            <input type="hidden" name="imagePath" value="${news.enclosure.url}">
                            <input type="hidden" name="title" value="${news.title}">
                            <input type="hidden" name="description" value="${news.description}">
                            <button class="save-button">Add to archive</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<%@include file="global/footer.jsp" %>
</body>
</html>
