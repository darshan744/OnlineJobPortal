<!DOCTYPE html>
<html lang="en">
<%@ page import="com.onlinejob.Entities.Employer"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>

<body class="bg-dark">
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container">
        <% Employer user=(Employer) session.getAttribute("user"); %>
        <div class="row">
            <div class="col text-light">
                    <div class="d-flex flex-column card align-items-center bg-dark p-3 shadow-lg">
                        <img src="https://placehold.co/100" class="rounded-circle mx-auto" />
                        <h5>
                            <%= user.getName() %>
                        </h5>
                        <form action="updateEmployer" method="post" class="gap-2">
                            <div class="row">
                                <div class="col form-group mb-3">
                                    <label for="companyName">Company Name</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light" type="button" onclick="openEditOption('companyName')">Edit</button>
                                        </div>
                                        <input type="text" name="companyName" id="companyName" value="<%= user.getCompanyName() %>" class="form-control" disabled>
                                        
                                    </div>
                                </div>
                                <div class="col form-group mb-3">
                                    <label for="name">Name</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light" type="button" onclick="openEditOption('name')">Edit</button>
                                        </div>
                                        <input type="text" name="name" id="name" value=<%= user.getName() %> class="form-control" disabled>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col form-group mb-3">
                                    <label for="username">User Name</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light" type="button" onclick="openEditOption('username')">Edit</button>
                                        </div>
                                        <input type="text" name="username" id="username" value=<%= user.getUsername() %> class="form-control" disabled>
                                        
                                    </div>
                                </div>
                                <div class="col form-group mb-3">
                                    <label for="email">Email</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light" type="button" onclick="openEditOption('email')">Edit</button>
                                        </div>
                                        <input type="text" name="email" id="email" value=<%= user.getEmail() %> class="form-control" disabled>
                                       
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col form-group mb-3">
                                    <label for="phonenumber">Phone Number</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light" type="button" onclick="openEditOption('phonenumber')">Edit</button>
                                        </div>
                                        <input type="text" name="phonenumber" value="<%=user.getPhoneNumber()%>" id="phonenumber" class="form-control" disabled>
                                       
                                    </div>
                                </div>
                                <div class="col form-group mb-3">
                                    <label for="companyName">Password</label>
                                    <div class="input-group gap-2">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-light"type="button" onclick="openEditOption('password')">Edit</button>
                                        </div>
                                        <input type="password" name="password" id="password" class="form-control" disabled>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-outline-light">Save changes</button>
                            </div>
                        </form>
                    </div>
            </div>
            <div id="toast-container" class="position-fixed top-0 end-0 p-3">
                <div id="toast" class="toast align-items-center bottom-0" role="alert">
                  <div class="d-flex">
                      <div class="toast-body" id="toast-body"></div>
                      <button class="btn-close m-auto" data-bs-dismiss="toast"></button>
                  </div>
              </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
<script src="../JavaScriptResources/employerDashboard.js"></script>
</html>