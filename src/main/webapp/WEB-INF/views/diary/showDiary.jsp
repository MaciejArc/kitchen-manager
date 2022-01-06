<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <style type="text/css">

        .divTable {
            display: block;
            width: 100%;
        }

        .divTableRow {
            display: flex;
            width: 100%;
        }

        .divTableHeading {
            background-color: #EEE;
            display: table-header-group;
        }

        .divTableCell, .divTableHead {
            border: 1px solid #999999;
            display: block;
            padding: 10px 0px;
            text-align: center;
            min-width: 33%;
        }

        .divTableCell2 {
            border: 1px solid #999999;
            display: block;
            padding: 3px 10px;
            text-align: center;
            min-width: 50%;
        }

        .divTableCell3 {
            border: 1px solid #999999;
            display: flex;
            padding: 3px 10px;
            text-align: center;
            min-width: 33%;
        }

        .divTableHeading {
            background-color: #EEE;
            display: table-header-group;
            font-weight: bold;
        }

        .divTableFoot {
            background-color: #EEE;
            display: table-footer-group;
            font-weight: bold;
        }

        .divTableBody {
            display: block;
            width: 100%;
        }

        td {
            border: solid;
        }


        table.GeneratedTable {
            width: 100%;
            background-color: #fbe5e5;
            border-collapse: collapse;
            border-width: 2px;
            border-color: #201f1e;
            border-style: solid;
            color: #000000;
        }

        table.GeneratedTable td, table.GeneratedTable th {
            border-width: 2px;
            border-color: #201f1e;
            border-style: solid;
            padding: 3px;
            text-align: center;
        }

        table.GeneratedTable thead {
            background-color: #96ab9a;
        }
    </style>
    <title>Add Income</title>
</head>
<body>
<%--<h2>${diary.date}</h2>--%>
<%--<table border="solid">--%>
<%--    <tr>--%>
<%--        <td>x</td><td>Śniadanie</td><td>Obiad</td><td>Podwieczorek</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Jadłospis:</td><td>${diary.breakfast}</td><td>${diary.dinner}</td><td>${diary.tea}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Ilość:</td> <td>${diary.breakfastQuantity}</td><td>${diary.dinnerQuantity}</td><td>${diary.teaQuantity}</td>--%>
<%--    </tr>--%>


<%--</table>--%>

<%--<table border="solid">--%>
<%--    <tr>--%>
<%--        <td>Nazwa</td>--%>
<%--        <td>J.m.</td>--%>
<%--        <td>Cena jedn.</td>--%>
<%--        <td>Ilość</td>--%>
<%--        <td>wartość</td>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${diary.expenditureList}" var="ex">--%>
<%--        <tr>--%>

<%--            <td>${ex.product.name}</td>--%>
<%--            <td>${ex.product.unit}</td>--%>
<%--            <td>${ex.product.price}</td>--%>
<%--            <td>${ex.quantity}</td>--%>
<%--            <td>${ex.value}</td>--%>
<%--        </tr>--%>

<%--    </c:forEach>--%>

<%--</table>--%>
<div class="divTable">
    <div class="divTableBody">
        <div class="divTableRow">
            <div class="divTableCell"><h3>R-${diary.number}</h3><br>(Numer raportu)</div>
            <div class="divTableCell" style="font-size: larger"><h2>${diary.date}</h2></div>
            <div class="divTableCell">&nbsp;<h3>${diary.purpose}</h3>(P - Przedszkole<br>S - Stołówka)</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell"><b>Śniadanie</b><br>${diary.breakfast}<br>Ilość wydana: ${diary.breakfastQuantity}
            </div>
            <div class="divTableCell"><b>Obiad</b><br>${diary.dinner}<br>Ilość wydana: ${diary.dinnerQuantity}</div>
            <div class="divTableCell">
                <b>Podwieczorek</b><br>${diary.tea}<br>Ilość wydana: ${diary.teaQuantity}

            </div>
        </div>
        <div class="divTableRow">
            <table class="GeneratedTable">
                <thead>
                <tr>
                    <th>Nazwa</th>
                    <th>J.m.</th>
                    <th>Cena jedn.</th>
                    <th>Ilość</th>
                    <th>wartość</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${diary.expenditureList}" var="ex">
                    <tr>

                        <td>${ex.product.name}</td>
                        <td>${ex.product.unit}</td>
                        <td>${ex.product.price}</td>
                        <td>${ex.quantity}</td>
                        <td>${ex.value}</td>
                    </tr>

                </c:forEach>
                <tr>

                    <td colspan="3"></td>


                    <td><b>Suma:</b></td>
                    <td><b>${sumValue}</b></td>


                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>