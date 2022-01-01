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
<form:form modelAttribute="expenditure">

    <p>Produkt:</p>


    <form:select path="product" items="${products}" itemLabel="name"/>

    <p>Ilość:</p>
    <form:input path="quantity"/>

    <input type="submit" value="Wyślij">


</form:form>

<table>
    <tr>
        <td>Nazwa</td>
        <td>Ilość</td>

    </tr>
<c:forEach items="${expToday}" var="ex">
    <tr>

        <td>${ex.product.name}</td>
        <td>${ex.quantity}</td>
    </tr>

</c:forEach>

</table>

</body>
</html>