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
    <select name="number" style="font-size: large">
        <c:forEach items="${diaryNumber}" var="number">
            <option value="${number}">${number}</option>

        </c:forEach>  <input type="submit" value="Wyślij">
    </select>
</form:form>





</body>
</html>