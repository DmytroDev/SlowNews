<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Archive</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/news_archive.css">
</head>
<body>
<%@include file="global/header.jsp"%>
<div class="content-wrap">

    <%@include file="global/left-side-menu.jsp"%>
    <div class="content">
        <c:forEach items="${archiveList}" var="news">
            <div class="content-concrete-news">

                <div class="image-content">
                    <img class="news-picture" src="${news.imagePath}" alt="Image">
                </div>
                <div class="news-content">
                    <div class="news-title">
                        <h2>${news.title}</h2>
                    </div>
                    <div class="news-data">
                        <p class="news">${news.description}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<%@include file="global/footer.jsp"%>
<script src="../resources/lib/jquery-2.2.3.js"></script>
<script src="../resources/js/search-text.js"></script>
</body>
</html>
