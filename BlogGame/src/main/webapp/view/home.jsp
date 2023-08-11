<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/07/2023
  Time: 7:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Valorant blog</title>
    <style>
        img{
            width: 300px;
            height: 320px;
        }
    </style>
</head>
<body>
<h1>Valorant blog</h1>
<div>
    <form method="get" action="/search">
        <input type="text" name="header1">
        <button type="submit">Search</button>
    </form>
        <button type="button" class="btn btn-primary" onclick="window.location.href='/addBlog';">Manager Agent</button>
        <br>
        <table>
            <c:forEach items="${blog}" var="b">
                <tr>
                    <th><a href="/detail?id_post=${b.id_post}">${b.header}</a></th>
                    <th><img src="${b.img}" alt=""></th>
                    <th><a href="/editBlog?id_post=${b.id_post}">Edit</a></th>
                    <th><a href="/deleteBlog?id_post=${b.id_post}">Delete</a></th>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
