<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add-App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous">
    </script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cabin:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="post">
        <header class="d-flex flex-row-reverse column-gap-3 justify-content-around p-2 border bg-primary bg-gradient">
            <button type="submit" class="btn btn-outline-warning" >+ Post Add</button>
            <h4 class="pt-2">speed.lk</h4>
            <i class="bi bi-emoji-smile-fill fs-2 text-warning"></i>
        </header>
        <main>
            <table class="mt-2 table table-bordered table-hover">
                <thead>
                <tr>
                    <th>Image</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="add" items="${addList}">
                    <tr>
                        <td><img class="profile-picture"
                                 src="${empty add.pictureUrl ? 'img/avatar.png': add.pictureUrl}"></td>
                        <td>${add.name}</td>
                    </tr>

                </c:forEach>
                </tbody>
                <c:if test="${empty addList}">
                    <tfoot>
                    <tr>
                        <td colspan="4" class="text-center">
                            There are no student records to display
                        </td>
                    </tr>
                    </tfoot>
                </c:if>
            </table>
        </main>
    </form>


</body>
</html>