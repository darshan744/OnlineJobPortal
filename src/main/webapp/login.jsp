<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Bootstrap Practice</title>
    
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>
  <style>
    body{
      background-color: #eef2f6;
    }
    .nav-tabs .nav-link{
                  font-weight: bold;

    }
    .nav-tabs .nav-link.active{
      background-color: rgb(72, 72, 247);
      color:white;
            font-weight: bold;
    }
    
  </style>

  <body class="d-flex flex-column justify-content-center align-items-center"
      style="height: 100vh" style="height: 100%">
    <div
      class="card p-3 shadow-lg"
    >
      <ul style="border: none;" class="nav nav-tabs justify-content-center" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
          <button
            class="nav-link active"
            id="logintab"
            data-bs-toggle="tab"
            data-bs-target="#login"
            role="tab"
            aria-controls="login"
            aria-selected="true"
          >
            Login
          </button>
        </li>
        <li class="nav-item" role="presentation">
          <button
            class="nav-link"
            id="signuptab"
            role="tab"
            data-bs-toggle="tab"
            data-bs-target="#signup"
            aria-controls="signup"
          >
            SignUp
          </button>
        </li>
      </ul>
      <div class="tab-content mt-3" id="myTabContent">
        <div class="tab-pane fade show active" id="login" role="tabpanel">
          <form
            action="login"
            method="post"
            class="mx-auto"
            style="width: 450px"
          >
            <h4 class="text-center text-primary">Welcome to OnlineJobPortal</h4>
                    <h5 class="text-center">Login</h5>
            <div class="form-group mb-2">
              <label for="username-login" class="form-label">UserName</label>
              <input
                type="text"
                class="form-control"
                id="username-login"
                name="username"
                placeholder="UserName"
              />
            </div>
            <div class="form-group">
              <label for="pass-login" class="form-label">Password</label>
              <input
                type="password"
                name="password"
                id="pass-login"
                class="form-control"
                placeholder="password"
              />
            </div>
            <div class="d-flex justify-content-center mt-3">
              <button class="btn btn-primary w-100">Login</button>
            </div>
          </form>
        </div>
        <div class="tab-pane fade" id="signup" role="tabpanel">
          <form
            action="signup"
            method="post"
            class="rounded-2"
            style="width: 450px"
          >
            <h4 class="text-center text-primary">Welcome to OnlineJobPortal</h4>
            <h5 class="text-center">SignUp</h5>
            <div class="row mb-3 gy-1">
              <div class="col-6 form-group">
                <label for="name" class="form-label">Name</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  name="name"
                  placeholder="Name"
                />
              </div>
              <div class="col-6 form-group">
                <label for="email" class="form-label">Email</label>
                <input type="email" name="email" id="email" placeholder="Email" class="form-control">
              </div>
              <div class="col-12 form-group">
                <label for="roles">Role</label>
                  <select class="form-control" name="role" id="roles"><option value="EMPLOYER">
                      Employer
                  </option>
                  <option value="EMPLOYEE">
                      Job Seeker
                  </option>
              </select>
              </div>
            </div>
            <!-- Username and pass -->
            <div class="form-group mb-2">
              <label for="username" class="form-label">UserName</label>
              <input
                type="text"
                class="form-control"
                id="username"
                name="username"
                placeholder="UserName"
              />
            </div>
            <div class="form-group">
              <label for="pass" class="form-label">Password</label>
              <input
                type="password"
                name="password"
                id="pass"
                class="form-control"
                placeholder="Password"
              />
            </div>
            <div class="d-flex justify-content-center mt-3">
              <button class="btn btn-primary w-100">SignUp</button>
            </div>
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
    </div>
  </body>
  
  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
    <script src="JavaScriptResources/toastMessage.js"></script>
</html>