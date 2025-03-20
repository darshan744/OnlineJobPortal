<!DOCTYPE html>
<html lang="en">
<%@ page import="com.onlinejob.Entities.User"%>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>

<body>
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container">
        <% User user=(User) session.getAttribute("user"); %>
            <div class="row">
                <div class="col">
                    <div class="d-flex flex-column card align-items-center p-3">
                        <img src="https://placehold.co/100" class="rounded-circle mx-auto" />
                        <h5>
                            <%= user.getName() %>
                        </h5>
                        <p>Full Stack Dev</p>
                    </div>
                </div>
                <div class="col">
                    <div>
                        
                    </div>
                </div>
            </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

</html>