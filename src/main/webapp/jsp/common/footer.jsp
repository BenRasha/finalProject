<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='<c:url value="../../css/common/header.css"/>'>
    <link rel="stylesheet" href='<c:url value="../../css/bootstrap.min.css"/>'>
    <script src='<c:url value="../../js/bootstrap.js"/> '></script>
    <title>Main</title>
</head>
<body>
    <table class="table table-borderless table-dark">
        <thead class="thead-dark">
        <tr>
            <th scope="col" class="table-text">
                <div class="text-light">Artist</div>
            </th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col"></th>
            <th scope="col">
                <div class="text-light">Socials</div>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td scope="row">
                <div class="text-light table-text">Veronika Luzan</div>
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <c:url value="../../icon/icons/instagram.svg" var="instagramUrl"/>
                <img src='<c:out value="${instagramUrl}"/>' alt="Instagram">
                <a href="https://www.instagram.com/_ve.lu_/">_ve.lu_</a>
            </td>
        </tr>
        <tr>
            <td scope="row"></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <c:url value="../../icon/icons/messenger.svg" var="messengerUrl"/>
                <img src='<c:out value="${messengerUrl}"/>' alt="Messenger">
                <a href="https://vk.com/roniiiiiiiiiiiii">Veronika</a>
            </td>
        </tr>
        </tbody>
</table>
</body>