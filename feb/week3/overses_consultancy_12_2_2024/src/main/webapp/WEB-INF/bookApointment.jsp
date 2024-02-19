<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Bootstrap Example</title>
</head>

<body class="">
    <%@ include file="navbar.jsp" %>

        <div class="d-flex flex-row justify-content-center align-items-center">
            <div class="container card  mt-5 p-5">

                <h1>Book an Appointment</h1>

                <form action="/student/bookApointment/" method="post">
                    <div class="mb-3" hidden>
                        <input type="number" name="consultant_Id" class="form-control" value="${consoltentId}"
                            id="inputApointmentId" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3" hidden>
                        <input type="number" name="student_Id" class="form-control" value="${studentId}"
                            id="inputApointmentId" aria-describedby="emailHelp">
                    </div>

                    <div class="mb-3">
                        <label for="inputStartTime" class="form-label">Start Time</label>
                        <input type="datetime-local" name="startTime" class="form-control" id="inputStartTime"
                            aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="inputEndTime" class="form-label">End Time</label>
                        <input type="datetime-local" name="endTime" class="form-control" id="inputEndTime"
                            aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">discription</label>
                        <input type="datetime-local" name="description" class="form-control" id="description"
                            aria-describedby="emailHelp">
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>