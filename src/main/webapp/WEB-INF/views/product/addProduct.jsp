<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <title>Add product</title>
</head>
<body>
<form:form modelAttribute="product">

    <p>Nazwa:</p>
    <form:input path="name"/>
    <p>Cena:</p>
    <form:input path="price"/>
    <p>J.m.</p>
    <form:input path="unit"/>
    <input type="submit" value="Wyślij">


</form:form>

</body>
</html>