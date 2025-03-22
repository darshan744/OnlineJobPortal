<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.onlinejob.Entities.JobDetails , java.util.List , com.onlinejob.Entities.JobSeeker" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
        crossorigin="anonymous" 
    /><!-- Option 1: Include in HTML -->
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Listings</title>
</head>
<body class="bg-dark">
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container mt-2 mb-2">
        <div class="card shadow-lg bg-dark text-light">
            <div class="card-header">
                <h2>${jobDetails.jobRole} at ${jobDetails.companyName}</h2>
            </div>
            <div class="card-body">
                <p>
                    <strong>Location : </strong>${jobDetails.location}
                </p>
                <p>
                    <strong>Salary : </strong>${jobDetails.salary}
                </p>
                <p><strong>Posted On : </strong>${jobDetails.postedDate}</p>
                <p><strong>Last Date to apply : </strong>${jobDetails.lastDateToApply}</p>
                <p><strong>JobType : </strong>${jobDetails.jobType}</p>
                
                <h5 class="mt-4">Skills Required</h5>
                <ul class="list-group list-group-flush bg-dark">
                    <c:forEach var="skill" items="${jobDetails.skills}">
                        <li class="list-group-item bg-dark text-light">${skill}</li>
                    </c:forEach>
                </ul>

                <h5 class="mt-4">
                    Job Description
                </h5>
                <p>${jobDetails.jobDescription}</p>

                <h5 class="mt-4">Applied JobSeekers</h5>

                <table class="table table-bordered table-striped table-dark">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>LinkedIn</th>
                            <th>GitHub</th>
                            <th>LeetCode</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="jobseeker" items="${jobDetails.appliedSeekers}" varStatus="countObj">
                            <td>${countObj.index}</td>
                            <td>
                                ${jobDetails.name}
                            </td>
                            <td>
                                <a href="${jobseeker.linkedInLink}">LinkedIn</a>
                            </td>
                            <td>
                                <a href="${jobseeker.githubLink}">GitHub</a>
                            </td>
                            <td>
                                <a href="${jobseeker.leetCodeLink}">LeetCode</a>
                            </td>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</html>