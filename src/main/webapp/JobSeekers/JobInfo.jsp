<!DOCTYPE html>
<html lang="en">
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" integrity="sha384-tViUnnbYAV00FLIhhi3v/dWt3Jxw4gZQcNoSCxCIFNJVCx7/D55/wXsrNIRANwdD" crossorigin="anonymous">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Info</title>
</head>
<body class="bg-dark">
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container mt-2 mb-2">
        <div class="card shadow-lg bg-dark text-light">
            <div class="card-header">
                <h2>${jobDetails.jobRole} at ${jobDetails.companyName}</h2>
            </div>
            <div class="card-body">
                <h5 class="mb-4">
                    Job Description
                </h5>
                <p>${jobDetails.jobDescription}</p>
                <p>
                    <strong>Location : </strong>${jobDetails.location}
                </p>
                <p>
                    <strong>Salary : </strong>${jobDetails.salary}
                </p>
                <p><strong>Posted On : </strong>${jobDetails.postedDate}</p>
                <p class="text-warning"><strong>Last Date to apply : </strong>${jobDetails.lastDateToApply}</p>
                <p><strong>JobType : </strong>${jobDetails.jobType}</p>
                
                <h5 class="mt-4">Skills Required</h5>
                <ul class="list-group list-group-flush bg-dark">
                    <c:forEach var="skill" items="${jobDetails.skills}">
                        <li class="list-group-item bg-dark text-light">${skill}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="card-footer">
                <form method="post" action="applyToJob?jobId=${jobDetails.id}" class="d-flex justify-content-center">
                    <button class="w-50 btn btn-outline-success">Apply</button>
                </form>
            </div>
        </div>
    </div>
    <div id="toast-container" class="position-fixed top-0 end-0 p-3">
        <div id="toast" class="toast align-items-center bottom-0" role="alert">
          <div class="d-flex">
              <div class="toast-body" id="toast-body"></div>
              <button class="btn-close m-auto" data-bs-dismiss="toast"></button>
          </div>
      </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
    <script src="../JavaScriptResources/toastMessage.js"></script>
</html>