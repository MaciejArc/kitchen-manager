<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <title>Add Income</title>
</head>
<body>
<h3>${productName}</h3>
<form:form modelAttribute="expenditure">


    <p>Ilość:</p>
    <form:input path="quantity"/>

    <p>Przeznaczenie:</p>
    <form:select path="purpose">
        <form:option value="S">Stołówka</form:option>
        <form:option value="P">Przedszkole</form:option>

    </form:select>

    <input type="submit" value="Dodaj kolejny rozchód">


</form:form>

<table>
    <tr>
        <td>Nazwa${type}</td>
        <td>Ilość</td>
        <td>Przeznaczenie</td>
        <td>Akcja</td>

    </tr>
    <c:forEach items="${expToday}" var="ex">
        <tr>

            <td>${ex.product.name}</td>
            <td>${ex.quantity}</td>
            <td>${ex.purpose}</td>
            <td><a href="http://localhost:8080/expenditure/delete?id=${ex.id}">Usuń</a> </td>
        </tr>

    </c:forEach>

</table>
<a href="http://localhost:8080/income/add?type=${type}">Dodaj kolejny produkt</a>
</body>
</html>