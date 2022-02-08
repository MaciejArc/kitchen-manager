<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <title>Add product</title>
    <style type="text/css">

        .divTable {
            display: block;
            width: 100%;
        }

        .divTableRow {
            display: flex;
            width: 95%;
        }

        .divTableCell, .divTableHead {
            border: 1px solid #999999;
            display: block;
            padding: 3px 10px;
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

        .divTableBody {
            display: block;
            width: 100%;
        }

        td {
            border: solid;
        }

    </style>
</head>
<body>
<div class="divTable">
    <div class="divTableBody">
        <div class="divTableRow">
            <div class="divTableCell"><h3>Index: ${product.id}</h3></div>
            <div class="divTableCell" style="font-size: larger"><h2>${product.name}</h2></div>
            <div class="divTableCell">&nbsp;</div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell">j.m <br/><b>${product.unit}</b>
            </div>
            <div class="divTableCell">Cena: <br/><b>${product.price}</b></div>
            <div class="divTableCell3">
                <div class="divTableCell2" style="min-width: 45%">Stan: <br/><b>${product.stock}</b>

                </div>
                <div class="divTableCell2" style="min-width: 45%">Wartość: <br/><b>${product.value}</b>

                </div>
            </div>
        </div>
        <div class="divTableRow">
            <div class="divTableCell2"><b>Przychody</b><br/>
                <table style="width: 100%; border-collapse: collapse; border: solid">
                    <thead>
                    <tr>
                        <td>Data</td>
                        <td>Symbol<br/>i nr<br/>dowodu</td>
                        <td>Przeznaczenie</td>
                        <td>Przychód</td>
                        <td>Wartość</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${incomeList}" var="incom">


                        <tr>
                            <td>${incom.pickUpDate}</td>
                            <td>F</td>
                            <td></td>
                            <td>${incom.quantity}</td>
                            <td>${incom.value}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <c:forEach items="${incomeQuantityAndValue}" var="quantityAndValue">
                            <td>Suma: ${quantityAndValue}</td>
                        </c:forEach>

                    </tr>
                    </tbody>


                </table>

            </div>
            <div class="divTableCell2"><b>Rozchody</b> <br/>
                <table style="width: 100%; border-collapse: collapse; border: solid">
                    <thead>
                    <tr>
                        <td>Data</td>
                        <td>Symbol<br/>i nr<br/>dowodu</td>
                        <td>Przeznaczenie</td>
                        <td>Rozchód</td>
                        <td>Wartość</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${expenditureList}" var="exp">


                        <tr>
                            <td>${exp.pickUpDate}</td>
                            <td>-</td>
                            <td> R - ${exp.diaryNumber}</td>
                            <td>${exp.quantity}</td>
                            <td>${exp.value}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <c:forEach items="${expenditureQuantityAndValue}" var="quantityAndValue">
                            <td>Suma: ${quantityAndValue}</td>
                        </c:forEach>

                    </tr>
                    </tbody>


                </table>

            </div>
        </div>
    </div>
</div>


</body>
</html>