<!DOCTYPE html>
<html lang="en">
<%@ page import="com.onlinejob.Entities.Employer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>

<body class="bg-dark">
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container">
        <% Employer user=(Employer) session.getAttribute("user"); %>
        <div class="row">
                <div class="col text-light">
                    <div class="d-flex flex-column card align-items-center bg-dark p-3">
                        <img src="https://placehold.co/100" class="rounded-circle mx-auto" />
                        <h5>
                            <%= user.getName() %>
                        </h5>
                        <div class="gap-2">
                            <div class="form-group mb-3">
                                <label for="companyName">Company Name</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('companyName')">Edit</button>
                                    </div>
                                    <input type="text" name="companyName" id="companyName" value=<%= user.getCompanyName() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="companyName">Name</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('name')">Edit</button>
                                    </div>
                                    <input type="text" name="name" id="name" value=<%= user.getName() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="companyName">User Name</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('username')">Edit</button>
                                    </div>
                                    <input type="text" name="username" id="username" value=<%= user.getUsername() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="companyName">Email</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('email')">Edit</button>
                                    </div>
                                    <input type="text" name="email" id="email" value=<%= user.getEmail() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <label for="companyName">Phone Number</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('phonenumber')">Edit</button>
                                    </div>
                                    <input type="text" name="phonenumber" id="phonenumber" value=<%= user.getPhoneNumber() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-group mb-3">
                                <label for="companyName">Password</label>
                                <div class="input-group gap-2">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-light" onclick="openEditOption('password')">Edit</button>
                                    </div>
                                    <input type="password" name="password" id="password" value=<%= user.getPassword() %> class="form-control" disabled>
                                    <div class="input-group-append">
                                        <button class="btn btn-light">Update</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col text-light">
                    <c:if test="${not empty sessionScope.user.postedJobs}"> 
                        <c:forEach var="jobs" items="${sessionScope.user.getPostedJobs}">
                            <table class="table text-light">
                                <thead>
                                    <tr>
                                        <th>JobRole</th>
                                        <th>Last Date to Apply</th>
                                        <th>URL to JobDetails</th>
                                    </tr>
                                </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                ${jobs.getJobRole}
                                            </td>
                                            <td>
                                                ${jobs.lastDateToApply}
                                            </td>
                                            <td>
                                                <a href="job.jsp">JobDetails</a>
                                            </td>
                                        </tr>
                                    </tbody>
                            </table>
                        </c:forEach>
                    </c:if>
                    
                </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
<script src="../JavaScriptResources/employerDashboard.js"></script>
</html>