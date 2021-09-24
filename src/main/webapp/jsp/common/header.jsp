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
<nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href='<c:url value="../../index.jsp"/>'>
        <c:url value="../../icon/icons/house.svg" var="homeUrl" />
        <img class="icon" src='<c:out value="${homeUrl}"/>' alt="List">
    </a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href='<c:url value="../abstract.jsp"/>'>ABSTRACT</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">REALISM</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">CONTEMPORARY</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">SKETCHING</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <a href="#">
            <c:url value="../../icon/icons/bookmark-heart-fill.svg" var="heartUrl" />
            <img class="icon" src='<c:out value="${heartUrl}"/>' alt="Bootstrap">
        </a>
    </ul>
    <ul class="navbar-nav">
        <a href='<c:url value="../login.jsp"/>'>
            <c:url value="../../icon/icons/person-fill.svg" var="personUrl" />
            <img class="icon" src='<c:out value="${personUrl}"/>' alt="Bootstrap">
        </a>
    </ul>
    <ul class="navbar-nav">
        <a href="#">
            <c:url value="../../icon/icons/translate.svg" var="languageUrl"/>
            <img class="icon" src='<c:out value="${languageUrl}"/>' alt="Language">
        </a>
    </ul>
</nav>