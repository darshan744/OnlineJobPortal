<!DOCTYPE html>
<html lang="en">
<%@ page import="java.util.List , com.onlinejob.Entities.JobDetails" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
        crossorigin="anonymous" 
    /><!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your postings</title>
</head>
<body class="bg-dark p-1 text-light">
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container mt-2">
        <div class="row">
            <h3 class="col-12">Your Postings</h3>
        </div>
        <div class="row gap-4">
            <%
                List<JobDetails> jobDetails = (List<JobDetails>) session.getAttribute("jobs");
                for(JobDetails jobs : jobDetails) {
            %>
            <div class="card bg-dark text-light border-light shadow-lg" style="width: 500px;">
                <div class="card-header border-light">
                    <h6><%= jobs.getJobRole() %></h6>
                </div>
                <div class="card-body">
                    <p>Skills Required : </p>
                    <ul> 
                        <% for(String skill :  jobs.getSkills()) { %>
                        <li>
                            <%= skill %>
                        </li>
                        <% } %>
                    </ul>
                </div>
                <div class="card-footer d-flex justify-content-between align-items-center border-light">
                    <h6 class="d-flex justify-content-center align-items-center gap-1"> 
                        <i class="bi bi-geo-alt-fill"></i>
                        <%= jobs.getLocation() %>    
                    </h6>
                    <a href="JobInfo?jobId=<%=jobs.getId()%>" class="btn btn-outline-info">
                        Open</a>
                </div>
            </div>
            <% 
         
            } %>
        </div>
    </div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</html>