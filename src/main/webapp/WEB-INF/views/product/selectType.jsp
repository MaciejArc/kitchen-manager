<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <style type="text/css">
        body {

        }

        .container {
            background-color: rgb(158, 205, 236);
            width: 100%;
            height: 1000px;
            display: block;

        }

        .header {
            padding-top: 2px;
            width: 99%;
            height: 10%;
            margin: 1%;
        }

        .leftMenu {

            width: 10%;
            height: 90%;
        }

        .myButton {
            box-shadow: 0px 0px 0px 2px #9fb4f2;
            background: #7892c2 linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
            border-radius: 10px;
            border: 1px solid #4e6096;
            display: inline-block;
            cursor: pointer;
            color: #ffffff;
            font-family: Arial;
            font-size: 19px;
            padding: 12px 37px;
            text-decoration: none;
            text-shadow: 0px 1px 0px #283966;
            margin: 1px;
            width: 100%;
        }

        .myButton:hover {
            background: #476e9e linear-gradient(to bottom, #476e9e 5%, #7892c2 100%);
        }

        .myButton:active {
            position: relative;
            top: 1px;
        }

    </style>
    <title>Dashboard</title>
</head>
<body>
<div class="container">
    <div class="header">
        <h2 style="text-align: center">Wybierz kategorie</h2>

    </div>
    <div class="leftMenu">
        <a href="http://localhost:8080/product/selectType?type=Dairy&id=&price=" class="myButton">Nabiał</a>
        <a href="http://localhost:8080/product/edit?type=Meat&id=&price=" class="myButton">Mięso</a>
        <a href="http://localhost:8080/product/edit?type=VegetablesFruits&id=&price=" class="myButton">Warzywa i
            owoce</a>
        <a href="http://localhost:8080/product/edit?type=Loose&id=&price=" class="myButton">Sypkie</a>
        <a href="http://localhost:8080/product/edit?type=Another&id=&price=" class="myButton">Inne</a>
        <br>
        <a href="http://localhost:8080/diary/show?number=1" class="myButton" style="margin-top: 20px">Wstecz</a>

    </div>
</div>


</body>
</html>