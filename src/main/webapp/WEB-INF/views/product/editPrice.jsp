<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
<style>
    .hide{
        display: none;
    }
</style>
    <title>Add Income</title>
</head>
<body>
<%--<form:form method="get">--%>
<%--    <a href="http://localhost:8080/income/selectType">Wstecz</a>--%>
    <p>Produkt:</p>
    <%--    <c:forEach items="${products}" var="product">--%>

    <%--        <form:select path="product" v--%>

    <%--    </c:forEach>--%>
   <form method="get" >


    <select name="id">
<c:forEach items="${products}" var="product"  >
    <option value="${product.id}">${product.name}</option>

</c:forEach></select>
<p>Cena:</p>
<input type="text" name="price">
       <input name="type" class="hide" >
       <button type="submit">Wyślij</button>
</form>
<%--    <form:select path="product" items="${products}"  itemLabel="name" cssStyle="font-size: large"/>--%>


<%--    <p>Ilość:</p>--%>
<%--    <form:input path="quantity"/>--%>

<%--    <input type="submit" value="Wyślij">--%>


<%--</form:form>--%>

</body>
</html>