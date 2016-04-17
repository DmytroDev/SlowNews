<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="global/header.jsp"/>
<div class="content-wrap">

    <%@include file="global/left-side-menu.jsp" %>
    <div class="content">
        <c:forEach items="${newsList}" var="news">
            <div class="content-concrete-news">

                <div class="image-content">
                    <img class="news-picture" src="${news.enclosure.url}" alt="Image">
                </div>
                <div class="news-content">
                    <div class="news-title">
                        <h2>${news.title}</h2>
                    </div>
                    <div class="news-data">
                        <p class="news">${fn:trim(news.description)}</p>
                    </div>
                    <c:if test="${username!=guest}">
                        <form action="/news" id="add-to-archive-form" method="post">
                            <input type="hidden" name="imagePath" value="${news.enclosure.url}">
                            <input type="hidden" name="title" value="${news.title}">
                            <input type="hidden" name="description" value="${news.description}">
                            <button id="add-archive-button">Add to archive</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

