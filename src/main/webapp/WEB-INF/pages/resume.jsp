<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список резюме</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/CSS/master.css">
    <script src="${pageContext.servletContext.contextPath}/JS/index.js"></script>
</head>
<body>

<div class="list">
        <div class="resume_item">
            <div class="resume_photo">
                <img src="${resume.pictureLink!=null ? resume.pictureLink : "/img/no_photo.jpg"}" class="ui image">
                <div class="edit_resume_button">
                    <a href="/resumes/delete/${resume.id}">Удалить</a></div>
            </div>
            <div class="resume_text resume_text_left">
                <div class="resume_field">
                    <a class="resume_link" href="${resume.resumeLink}">${resume.positionName}"</a>
                </div>
                <div class="resume_field fio_age">
                    ${resume.fio}, ${resume.age}
                </div>
                <div class="resume_field thin_font">
                    ${resume.lastVisit} ${resume.city}
                </div>
                <div class="resume_field heavy_font separator">
                    Последнее место работы
                </div>
                <div class="resume_field last_place">
                    ${resume.lastPlaceOfWork}
                </div>
                <div class="resume_field last_name">
                    ${resume.lastPositionName}
                </div>
                <div class="resume_field last_duration">
                    ${resume.lastPlaceDuration}
                </div>
            </div>

            <div class="resume_text resume_text_right">
                <div class="resume_field heavy_font">
                    ${resume.wageLevel}
                </div>
                <div class="resume_field thin_font">
                    ${resume.experience}
                </div>
                <div class="resume_field thin_font">
                    ${resume.education}
                </div>
            </div>
        </div>
</div>
</body>
</html>