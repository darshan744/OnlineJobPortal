<!DOCTYPE html>
<html lang="en">

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body class="bg-dark">
    <jsp:include page="employernavbar.jsp"></jsp:include>
    <div class="container mt-5 d-flex justify-content-center">
        <form class="w-50 text-light p-3 rounded-2" action="jobposting" method="post">
            <div class="form-group">
                <label for="jobRole" class="form-label">JobName</label>
                <input type="text" name="jobRole" id="jobRole" placeholder="Job Name" class="form-control">
            </div>
            <div class="form-group">
                <label for="jobDescription" class="form-label">Job Description</label>
                <textarea name="jobDescription" id="jobDescription" placeholder="Job Description" class="form-control"></textarea>
            </div>
            <div class="form-group">
                <label for="salary" class="form-label">Salary LPA</label>
                <input type="number" name="salary" id="salary" placeholder="Salary" class="form-control">
            </div>
            <div class="form-group">
                <label for="lastDateToApply" class="form-label">LastDate to Apply</label>
                <input type="date" name="lastDateToApply" id="lastDateToApply" class="form-control">
            </div>
            <div class="form-group">
                <label for="jobType" class="form-label">Job Type</label>
                <select name="jobType" id="jobType" class="form-control">
                    <option value="" disabled>Select Job Type</option>
                    <option value="FULL_TIME">Full Time</option>
                    <option value="PART_TIME">Part Time</option>
                    <option value="INTERNSHIP">Internship</option>
                </select>
            </div>
            <div class="form-group">
                <label for="location" class="form-label">Location</label>
                <input type="text" name="location" id="location" class="form-control" placeholder="Location">
            </div>
            <div class="d-flex justify-content-center mt-3">
                <div class="w-50">
                    <button class="btn btn-outline-light w-100 d-block">Submit</button>
                </div>
            </div>
        </form>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

</html>