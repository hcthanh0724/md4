<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/07/2023
  Time: 5:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label>IMG:</label>
        <input type="text" class="form-control"  value="${blog.img}" name="img">
    </div>
    <div class="form-group">
        <label>Background IMG:</label>
        <input type="text" class="form-control" value="${blog.background_img}" name="background_img">
    </div>
    <div class="form-group">
        <label>Header:</label>
        <input type="text" class="form-control" value="${blog.header}" name="header">
    </div>
    <div class="form-group">
        <label>Role:</label>
        <input type="text" class="form-control" value="${blog.role}" name="role">
    </div>
    <div class="form-group">
        <label>Biography:</label>
        <input type="text" class="form-control" value="${blog.biography}" name="biography">
    </div>
    <div class="form-group">
        <input type="hidden" class="form-control" value="${blog.id_post}" name="id_post">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
