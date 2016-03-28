<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>News</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/news.css">
</head>
<body>
<div class="header">
    <p class="header-msg">SlowNews</p>
</div>

<div class="content-wrap">

    <div class="left-menu">
        <ul class="list">
            <li class="news-item">
                <a href="/news">News</a>
            </li>
            <li class="archive-item">
                <a href="/archive">Archive</a>
            </li>

        </ul>
    </div>
    <div class="content">
        <c:forEach items="${newsList}" var="news">
            <div class="content-concrete-news">

                <div class="image-content">
                    <img class="news-picture" src="${news.imagePath}" alt="Image">
                </div>
                <div class="news-content">
                    <div class="news-title">
                        <h2>${news.title}</h2>
                    </div>
                    <div class="news-data">
                        <p>${news.description}</p>
                    </div>
                    <div class="save-button">
                        <button>Add to archive</button>
                    </div>

                </div>
            </div>
        </c:forEach>


    </div>

</div>

<div class="footer">
    <p> Copyright: "Infinity, inc.", 2016</p>
</div>

</body>
</html>
