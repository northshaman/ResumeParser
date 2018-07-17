<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaman
  Date: 17.07.2018
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список резюме</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/CSS/master.css">
    <script src="${pageContext.servletContext.contextPath}/JS/jquery-1.10.0.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/JS/index.js"></script>
</head>
<body>
<div class="header">
    <h1>Резюме:</h1>
</div>
<form autocomplete="off" class="ui form">
    <div class="wrapper">
        <div class="container">
            <div class="menu_item box">
                <div class="box_inner">
                    <input class="search-input" required placeholder="Город">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Зарплата">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Стаж">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Возраст">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Должность">
                </div>

                <div class="box_inner">
                    <button type="button" class="bttn icons bttn-settings">Найти</button>
                </div>
            </div>

        </div>
    </div>
</form>


<div class="list">
    <c:forEach var="resume" items="${resumes}">
        <jsp:useBean id="resume" scope="page" type="com.shaman.parser.entity.Resume"/>
        <div class="resume_item">
            <div class="resume_photo">
                <img src="${resume.pictureLink!=null ? resume.pictureLink : "/img/no_photo.jpg"}" class="ui image">
                <div class="edit_resume_button">Редактировать</div>
            </div>
            <div class="resume_text resume_text_left">
                <div class="resume_field">
                    <a class="resume_link" href="${resume.resumeLink}"> <c:out value="${resume.positionName}"/></a>
                </div>
                <div class="resume_field fio_age">
                    <c:out value="${resume.fio}"/>, <c:out value="${resume.age}"/>
                </div>
                <div class="resume_field thin_font">
                    <c:out value="${resume.lastVisit}"/> <c:out value="${resume.city}"/>
                </div>
                <div class="resume_field heavy_font separator">
                    Последнее место работы
                </div>
                <div class="resume_field last_place">
                    <c:out value="${resume.lastPlaceOfWork}"/>
                </div>
                <div class="resume_field last_name">
                    <c:out value="${resume.lastPositionName}"/>
                </div>
                <div class="resume_field last_duration">
                    <c:out value="${resume.lastPlaceDuration}"/>
                </div>
            </div>

            <div class="resume_text resume_text_right">
                <div class="resume_field heavy_font">
                    <c:out value="${resume.wageLevel}"/>
                </div>
                <div class="resume_field thin_font">
                    <c:out value="${resume.experience}"/>
                </div>
                <div class="resume_field thin_font">
                    <c:out value="${resume.education}"/>
                </div>
            </div>


        </div>
    </c:forEach>
</div>

</body>
</html>
