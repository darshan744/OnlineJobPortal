<html>
    <head>
      <%@ page import="java.util.List , com.onlinejob.Entities.JobDetails , com.onlinejob.services.JobDetailsDAO" %>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" integrity="sha384-tViUnnbYAV00FLIhhi3v/dWt3Jxw4gZQcNoSCxCIFNJVCx7/D55/wXsrNIRANwdD" crossorigin="anonymous">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    </head>
    <title>Jobs</title>
    <body class="bg-dark">
      <jsp:include page="navbar.jsp"></jsp:include>
      <div class="container mt-3 gap-4 d-flex">
          <% 
            JobDetailsDAO jobDao = JobDetailsDAO.getJobDetailsDAO();
            List<JobDetails> jobDetails = jobDao.getJobDetails();
            for(JobDetails jobs : jobDetails){  
          %>
          <div class="card bg-dark text-light border-light shadow-lg" style="width: 500px;">
            <div class="card-header border-light d-flex justify-content-between">
                <h6><%= jobs.getCompanyName() %></h6>
                <h6><i class="bi bi-geo-alt-fill"></i>
                <%= jobs.getLocation() %>
                </h6>
            </div>
            <div class="card-body">
                <h4>Skills Required : </h4>
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
                  <i class="bi bi-currency-rupee"></i>
                    <%= jobs.getSalary() %>    
                </h6>
                <a href="JobInfo?jobId=<%=jobs.getId()%>" class="btn btn-outline-info">
                    Open</a>
            </div>
        </div>
        <% } %>
        </div>
    </body>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
</html>