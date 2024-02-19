<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Register Page</title>
        <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
    </head>

    <body class="antialiased border-top-wide border-primary d-flex flex-column">
        <div class="page page-center mt-6">
            <div class="container-tight py-4">
                <div class="text-center mb-6">
                    <a href="."><img src="https://tabler.github.io/tabler/demo/brand/tabler.svg" alt="" height="36"></a>
                </div>
                <form class="card card-md" id="registerForm" action="/registerRestorent" method="post">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">Register as Restaurant</h2>
                        <div class="mb-3">
                            <label class="form-label">Restaurant Name</label>
                            <input type="text" class="form-control" id="restaurantName" name="name"
                                placeholder="Enter restaurant name" required>
                        </div>
                        <div class="mb-3">
                            <div class="row">
                                <div class="col">
                                    <label class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="email"
                                        placeholder="Enter email" required>
                                </div>
                                <div class="col">
                                    <label class="form-label">Contact Number</label>
                                    <input type="tel" class="form-control" id="contactNumber" name="contectNumber"
                                        placeholder="Enter contact number" required>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" id="address" name="address"
                                placeholder="Enter address" required>
                        </div>
                        <div class="mb-3">
                            <div class="row">
                                <div class="col">
                                    <label class="form-label">City</label>
                                    <select class="form-select" id="city" name="city" required>
                                        <c:forEach items="${cities}" var="city">
                                            <option value="${city.id}">${city.cityName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <label class="form-label">Area</label>
                                    <select class="form-select" id="area" name="area" required>

                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                placeholder="Password" required>
                        </div>
                        <div class="form-footer">
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </div>
                    </div>
                </form>
                <div class="text-center text-muted mt-3">
                    Already have an account? <a href="/login" tabindex="-1">Login</a>.
                </div>
            </div>
        </div>
        <script>
            document.getElementById("city").onchange = (e) => {
                area = document.getElementById("area");
                area.innerHTML = "";
                let selected = e.target.value;
                for (let i = 0; i < ALL_AREA.length; i++) {
                    const element = ALL_AREA[i];
                    if (selected == element.cityId) {
                        node = document.createElement("option");
                        node.value = element.id;
                        node.innerText = element.name;
                        area.appendChild(node);
                    }

                }
            };
            const ALL_AREA = [];

            <c:forEach items="${areas}" var="area">
                ALL_AREA.push({
                    id : ${area.id},
                name:"${area.areaName}",
                cityId:${area.cityId}
                });
            </c:forEach>


        </script>
    </body>

    </html>