<%--
  Created by IntelliJ IDEA.
  User: dellyx
  Date: 2020-05-05
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<head>
    <title>index</title>
    <script>
        var path = "${path}";
    </script>

    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .map {
            width: 100vw;
            height: 100vh;
        }
    </style>
</head>
<body>
<div id="map" class="map"></div>
<script src="${path}/lib/jquery-3.4.1.js"></script>
<script src="${path}/ol/ol.js"></script>
<link rel="stylesheet" href="${path}/ol/ol.css">
<script src="${path}/js/index.js"></script>
</body>
</html>
