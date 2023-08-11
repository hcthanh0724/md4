<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/07/2023
  Time: 9:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Title</title>
    <style>
        #avatar{
            width: 110px;
            height: 130px;
        }
    </style>
</head>
<body>
<div class="container">
<c:set var = "detail" />
    <div class="row">
        <div class="col-12">
            <h1>${detail.header}</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <img src="${detail.background_img}" class="img-fluid" alt="Image">
        </div>
    </div>
    <div class="row">
        <div class="col-md-5">
            <div class="row">
                <div class="col-md-6">
                    <h2>Col 2</h2>
                    <img src="${detail.img}" id="avatar">
                </div>
                <div class="col-md-6">
                    <h2>Col 3</h2>
                    <p>${detail.role}</p>
                </div>
            </div>
        </div>
        <div class="col-md-7">
            <h2>Col 5</h2>
            <p>${detail.biography}</p>
        </div>
    </div>
</div>
</body>
</html>
