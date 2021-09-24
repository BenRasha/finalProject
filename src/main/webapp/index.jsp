<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='<c:url value="css/index.css"/>'>
    <link rel="stylesheet" href='<c:url value="css/bootstrap.min.css"/>'>
    <script src='<c:url value="js/bootstrap.js"/> '></script>
    <title>Main</title>
</head>
<body>
<c:import url="jsp/common/header.jsp"/>
<c:url value="img/abstract/aurora_120×100/third.jpg" var="backgroundUrl"/>
<img class="background-image" src='<c:out value="${backgroundUrl}"/>' alt="Background"/>
<br>
<br>
<hr class="first-line">
<h3 class="table-text">OTHER WORKS</h3>
<hr class="second-line">
<br>
<br>
<c:url value="img/abstract/anarchy_120×100/first.jpg" var="abstractUrl"/>
<c:url value="img/realism/cigarette_40×30/first.jpeg" var="realismUrl"/>
<c:url value="img/sk/second/first.jpg" var="sketchUrl"/>
<table class="table table-borderless">
    <thead class="thead-dark">
        <tr>
            <th scope="col" class="table-text">Abstract</th>
            <th scope="col" class="table-text">Contemporary</th>
            <th scope="col" class="table-text">Sketch</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th scope="row">
                <a href='<c:url value="jsp/abstract.jsp"/>'>
                    <img class="table-picture" src='<c:out value="${abstractUrl}"/>' alt="Abstract">
                </a>
            </th>
            <td>
                <a href="#">
                    <img class="table-picture" src='<c:out value="${realismUrl}"/>' alt="Contemporary">
                </a>
            </td>
            <td>
                <a href="#">
                    <img class="table-picture" src='<c:out value="${sketchUrl}"/>' alt="Sketch">
                </a>
            </td>
        </tr>
    </tbody>
</table>
<br>
<br>
<br>
<c:import url="jsp/common/footer.jsp"/>
</body>
</html>