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
<a href="http://localhost:8080"><button>Wstecz</button></a>
<form:form modelAttribute="product">

    <p>Nazwa:</p>
    <form:input path="name"/>
    <p>Cena:</p>
    <form:input path="price"/>
    <p>J.m.</p>
    <form:input path="unit"/>
<p>Typ</p>
    <form:select path="type">
        <form:option value="Dairy">Nabiał</form:option>
        <form:option value="Loose">Sypkie</form:option>
        <form:option value="Meat">Mięso</form:option>
        <form:option value="VegetablesFruits">Warzywa i owoce</form:option>
        <form:option value="Another">Inne</form:option>
    </form:select>
    <input type="submit" value="Wyślij">


</form:form>

</body>
</html>