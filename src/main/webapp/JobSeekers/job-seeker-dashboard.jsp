<html>
 <%@ page import="com.onlinejob.Entities.User" %>
    <head>
        <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
         <div class="container mt-5">
         <%
            User user = (User) session.getAttribute("user");
          %>
      <div class="row">
        <div class="col-4">
          <div class="card p-3 d-flex flex-column align-items-center">
            <img
              src="https://placehold.co/100"
              class="rounded-circle mx-auto"
            />
            <h5><%= user.getName() %></h5>
            <p>Full Stack Dev</p>
          </div>
          <div>
            <div class="card mt-4 p-3 gap-2">
              <div class="form-group">
                <label for="githubLink" class="form-label d-flex align-items-center gap-1"><i class="fa-brands fa-github"></i>Github</label>
                <input class="form-control" placeholder="Github" type="text" />
              </div>
              <div class="form-group">
                <label for="LeetCodeLink" class="form-label form-label d-flex align-items-center gap-1">
                  <i class="fa-solid fa-code"></i>
                  LeetCode</label>
                <input class="form-control" placeholder="LeetCode" type="text" />
              </div>
              <div class="form-group">
                <label for="LinkedIn" class="form-label form-label d-flex align-items-center gap-1"><i class="fa-brands fa-linkedin"></i>LinkedIn</label>
                <input class="form-control" type="text" placeholder="LinkedIn" />
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card p-3">
            <div class="form-group">
              <label class="form-label"> UserName</label>
              <input type="text" class="form-control" value=<%= user.getUsername() %> />
            </div>
            <div class="form-group">
              <label class="form-label">Name</label>
              <input type="text" class="form-control" value=<%= user.getName() %> />
            </div>
            <div class="form-group">
              <label class="form-label">Email</label>
              <input
                type="text"
                class="form-control"
                value=<%= user.getEmail() %>
              />
            </div>
            <div class="form-group">
              <label class="form-label">Password</label>
              <input type="password" class="form-control" value="pass" />
            </div>
            <button class="btn btn-outline-primary mt-3">Update Profile</button>
          </div>
          <div>
            <div class="card p-3 mt-3">
              <h5>Applied Jobs</h5>
              <ul class="list-group">
                <li class="list-group-item">
                  Amazon
                </li>
                <li class="list-group-item">Google</li>
                <li class="list-group-item">Zoho</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    </body>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
</html>