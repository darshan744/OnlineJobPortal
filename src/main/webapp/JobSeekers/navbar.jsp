<html>

<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
</head>

<body>
  <nav class="navbar navbar-expand navbar-dark bg-dark">
    <a href="#" class="navbar-brand ms-3">Online Job Portal</a>
    <ul class="navbar-nav w-100">
      <li class="nav-item"><a href="Home.jsp" class="nav-link">Home</a></li>
      <li class="nav-item"><a href="Profile" class="nav-link">Profile</a></li>
    </ul>
    <form class="align-self-end me-4" action="<%= request.getContextPath() %>/logout" method="get">
      <button type="submit" class="btn btn-danger">Logout</button>
    </form>
  </nav>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>