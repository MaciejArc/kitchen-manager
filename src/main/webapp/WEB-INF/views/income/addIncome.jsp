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
<form:form modelAttribute="income">

    <p>Produkt:</p>
<%--    <c:forEach items="${products}" var="product">--%>

<%--        <form:select path="product" v--%>

<%--    </c:forEach>--%>

   <form:select path="product" items="${products}"  itemLabel="name"/>


    <p>Ilość:</p>
    <form:input path="quantity"/>

    <input type="submit" value="Wyślij">


</form:form>

</body>
</html>