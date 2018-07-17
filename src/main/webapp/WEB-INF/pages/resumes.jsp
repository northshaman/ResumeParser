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
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/CSS/jquery-ui.min.css">
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
                    <input class="search-input" required placeholder="Введите запрос">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Введите запрос">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Введите запрос">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Введите запрос">
                </div>
                <div class="box_inner">
                    <input class="search-input" required placeholder="Введите запрос">
                </div>
            </div>

        </div>
    </div>
</form>

<div class="list">
    <c:forEach var="resume" items="${resumes}">
        <jsp:useBean id="resume" scope="page" type="com.shaman.parser.entity.Resume"/>
        <div>
            <c:out value="${resume.fio}"/>
        </div>
        <br/>
    </c:forEach>
</div>

</body>
</html>
