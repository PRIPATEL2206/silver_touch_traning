<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Upadte User</title>
</head>

<body>
    <%@ include file="navbar.jsp" %>
        <div class="container mt-5">
            <div class="card p-3">
                <form action="/updateUser/${user.id}" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="username" class="form-label" aria-readonly="true">User Name</label>
                        <input type="text" class="form-control" id="username" name="username"
                            aria-describedby="username" readonly value="${user.username}">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                            value="${user.email}">
                    </div>

                    <div class="mb-3">
                        <label for="specification" class="form-label">Specification</label>
                        <input type="text" class="form-control" id="specification" name="specification"
                            aria-describedby="username" value="${user.specification}">
                    </div>
                    <div class="mb-3">
                        <label for="profile" class="form-label">Profile Image</label>
                        <input class="form-control" type="file" name="image" accept="image/*" id="profile">
                    </div>
                    <div class="m-2">
                        <a href="/user/changePassword/${user.id}">Change Password</a>
                    </div>

                    <button type="submit" class="btn btn-primary mb-5">Save</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</body>

</html>