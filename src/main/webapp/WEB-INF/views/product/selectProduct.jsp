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


<form:form method="get">
    <select name="id" style="font-size: large">
        <c:forEach items="${products}" var="product">
            <option value="${product.id}">${product.name}</option>

        </c:forEach> <input type="submit" value="Wyślij">
    </select>
</form:form>


</body>
</html>