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
<p>${diary.breakfast}</p>
<p>${diary.dinner}</p>
<p>${diary.tea}</p>
<table>
    <tr>
        <td>Nazwa</td>
        <td>Ilość</td>
        <td>wartość</td>

    </tr>
    <c:forEach items="${diary.expenditureList}" var="ex">
        <tr>

            <td>${ex.product.name}</td>
            <td>${ex.quantity}</td>
            <td>${ex.value}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>