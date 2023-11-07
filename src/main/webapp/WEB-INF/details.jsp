<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style.css">
    <style>
        .carouselImage{
            object-fit: cover;
            height: 100%;
            width: 100%;
            background-color: aqua;
        }
        #carouselExampleAutoplaying{
            width: 50%;
            margin: auto;
            background-color: aqua;
        }
    </style>
</head>
<body>
 <main >
     <h1>hi</h1>
     <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel" >
         <div class="carousel-inner">
             <div class="carousel-item active">
                 <img  src="${empty path ? 'img/avatar.png': path}" class="d-block w-50 carouselImage" alt="">
             </div>
             <div class="carousel-item">
                 <img src="${empty path ? 'img/avatar.png': path}" class="d-block w-50 carouselImage" alt="">
             </div>
             <div class="carousel-item">
                 <img src="${empty path ? 'img/avatar.png': path}" class="d-block w-50 carouselImage" alt="">
             </div>
         </div>
         <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
             <span class="carousel-control-prev-icon" aria-hidden="true"></span>
             <span class="visually-hidden">Previous</span>
         </button>
         <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
             <span class="carousel-control-next-icon" aria-hidden="true"></span>
             <span class="visually-hidden">Next</span>
         </button>
     </div>
<%--     <img class="profile-picture"--%>
<%--          src="${empty path ? 'img/avatar.png': path}" alt="">--%>
 </main>

</body>
</html>