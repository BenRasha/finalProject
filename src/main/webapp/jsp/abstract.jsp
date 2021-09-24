<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='<c:url value="../css/common/header.css"/>'>
    <link rel="stylesheet" href='<c:url value="../css/index.css"/>'>
    <link rel="stylesheet" href='<c:url value="../css/abstract.css"/>'>
    <link rel="stylesheet" href='<c:url value="../css/bootstrap.min.css"/>'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../js/bootstrap.bundle.js"></script>
    <title>Abstract</title>
</head>
<body>
<c:import url="common/header.jsp"/>
<div class="container-abstract">
    <div class="container-card">
        <div class="card text-white bg-dark border-warning mb-2 sort-card">
            <div class="card-header header">SORT</div>
                <div id="accordion">
                    <div class="card bg-dark border-warning">
                        <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-outline-light collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Size
                            </button>
                        </h5>
                        </div>
                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body text-dark bg-dark">
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="70x30">
                            <label for="70x30">70 x 30</label>
                        </li>
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="100x120">
                            <label for="100x120">100x120</label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="card bg-dark border-warning">
            <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-outline-light collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Material
                    </button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                <div class="card-body text-dark bg-dark">
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="Oil">
                            <label for="Oil">Oil</label>
                        </li>
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="Acrylic">
                            <label for="Acrylic">Acrylic</label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="card bg-dark border-warning">
            <div class="card-header" id="headingThree">
                <h5 class="mb-0">
                    <button class="btn btn-outline-light collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Date
                    </button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                <div class="card-body text-dark bg-dark">
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="February">
                            <label for="February">February</label>
                        </li>
                        <li class="list-group-item bg-warning list-item">
                            <input type="checkbox" id="August">
                            <label for="August">August</label>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer bg-dark border-warning text-primary mb-3">
        <ul class="list-group list-group-flush">
            <li class="list-group-item bg-dark">
                <c:url value="../icon/icons/instagram.svg" var="instagramUrl"/>
                <img src='<c:out value="${instagramUrl}"/>' alt="Instagram">
                <a href="https://www.instagram.com/_ve.lu_/">_ve.lu_</a>
            </li>
            <li class="list-group-item bg-dark">
                <c:url value="../icon/icons/messenger.svg" var="messengerUrl"/>
                <img src='<c:out value="${messengerUrl}"/>' alt="Messenger">
                <a href="https://vk.com/roniiiiiiiiiiiii">Veronika Luzan</a>
            </li>
        </ul>
    </div>
    </div>
    </div>
    <table class="table table-striped table-borderless mb-2">
        <thead class="thead-light">
        <tr>
            <th scope="col" class="table-head"></th>
            <th scope="col" class="table-head"></th>
            <th scope="col" class="table-head"></th>
        </tr>
        </thead>
        <tbody class="bg-dark text-light">
            <tr>
                <td scope="row">
                    <div class="card border-warning mb-3">
                        <c:url value="../img/realism/theSecondBirth_40×30/first.jpeg" var="firstUrl"/>
                        <img class="table-picture" src='<c:out value="${firstUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">The second birth</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
                <td>
                    <div class="card border-warning mb-3">
                        <c:url value="../img/contemporary/inYourHands_70×50/first.jpeg" var="secondUrl"/>
                        <img class="table-picture" src='<c:out value="${secondUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">In your hands</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
                <td>
                    <div class="card border-warning mb-3">
                        <c:url value="../img/contemporary/solarEclipse_70×50/first.jpeg" var="thirdUrl"/>
                        <img class="table-picture" src='<c:out value="${thirdUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">Solar eclipse</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
            </tr>
            <tr>
                <td scope="row">
                    <div class="card border-warning mb-3">
                        <c:url value="../img/realism/theSecondBirth_40×30/first.jpeg" var="firstUrl"/>
                        <img class="table-picture" src='<c:out value="${firstUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">The second birth</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
                <td>
                    <div class="card border-warning mb-3">
                        <c:url value="../img/contemporary/inYourHands_70×50/first.jpeg" var="secondUrl"/>
                        <img class="table-picture" src='<c:out value="${secondUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">In your hands</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
                <td>
                    <div class="card border-warning mb-3">
                        <c:url value="../img/contemporary/solarEclipse_70×50/first.jpeg" var="thirdUrl"/>
                        <img class="table-picture" src='<c:out value="${thirdUrl}"/>' alt="First">
                        <div class="card-body bg-dark">
                            <h1 class="card-title text-light">Solar eclipse</h1>
                        </div>
                        <ul class="list-group list-group-horizontal bg-primary">
                            <li class="list-group-item text-dark list-item">Size</li>
                            <li class="list-group-item text-dark list-item">Material</li>
                            <li class="list-group-item text-dark list-item">Date</li>
                        </ul>
                        <p><button>Add to Favourites</button></p>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<c:import url="common/footer.jsp"/>
</body>