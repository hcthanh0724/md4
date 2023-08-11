
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <input value="${student.id}" hidden="hidden" name="id"><br>
        <input value="${student.name}" name="name"><br>
        <input value="${student.age}" name="age"><br>
        <input value="${student.img}" name="img"><br>
        <button type="submit">Submit</button>
    </form>

</div>

</body>
</html>
