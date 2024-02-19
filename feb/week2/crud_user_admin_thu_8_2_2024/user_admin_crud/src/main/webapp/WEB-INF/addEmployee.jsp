<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>add Employee</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/adminDashbord">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/addEmployee">Add User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/allUsers">All Users</a>
                    </li>


                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container mt-2">
        <h1 class="text-center">Add Employee</h1>
        <form action="/addEmployee" method="post" enctype="multipart/form-data">
            <div class="form-group mb-3">
                <label for="username">UserName</label>
                <input type="text" class="form-control" name="userName" id="username" placeholder="User Name">
            </div>
            <div class="form-group mb-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="User Name">
            </div>

            <div class="form-group mb-3">
                <label for="email">Email address</label>
                <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp"
                    placeholder="Enter email">
            </div>
            <div class="form-group mb-3">
                <label for="phone">Phone Number</label>
                <input type="tel" class="form-control" id="phone" name="phoneNumber" placeholder="User Name">
            </div>
            <div class="form-group mb-3">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" name="password" id="exampleInputPassword1"
                    placeholder="Password">
            </div>

            <div class="form-group mb-3">
                <label for="education">Education</label>
                <input type="text" class="form-control" name="education" id="education" placeholder="Education">
            </div>
            <div class="form-group mb-3">
                <label for="company">Company Name</label>
                <input type="text" class="form-control" name="company" id="company" placeholder="Company Name">
            </div>
            <div class="mb-3">
                <label for="formFile" class="form-label">Employee Image</label>
                <input class="form-control" type="file" name="image" accept="image/*" id="formFile">
            </div>
            <div class="row me-2 ">

                <select class=" md-2 form-select col ml-2" id="country-dropdown" aria-label="Default select example">
                    <option selected>country</option>

                </select>
                <select class=" md-2 form-select col" id="state-dropdown" aria-label="Default select example">
                    <option selected>State</option>

                </select>
                <select class=" md-2 form-select col" id="city-dropdown" aria-label="Default select example">
                    <option selected>Distict</option>

                </select>
            </div>
            <div class="form-group mb-3" hidden>
                <label for="address">Address</label>
                <textarea class="form-control" id="address" name="Address" rows="3">,,</textarea>
            </div>
            <div class="form-group mb-3">
                <label for="selfBio">Self Bio</label>
                <textarea class="form-control" id="selfBio" name="selfBio" rows="3"></textarea>
            </div>

            <div class="form-check mb-3 ">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Terms & Conditions</label>
            </div>
            <button type="submit" class="btn btn-primary mb-5">Add Employee</button>
        </form>

    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

    <script>

        const locationData = {
            "USA": {
                "California": ["Los Angeles", "San Francisco"],
                "New York": ["New York City", "Buffalo"]
            },
            "India": {
                "Maharashtra": ["Mumbai", "Pune"],
                "Delhi": ["New Delhi", "Old Delhi"],
                "Gujarat": ["Ahmedabad", "Vadodra", "Surat", "Rajkot", "Mehsana"]
            }
        };

        function populateCountries() {
            const countryDropdown = document.getElementById('country-dropdown');
            Object.keys(locationData).forEach(country => {
                const option = document.createElement('option');
                option.value = country;
                option.innerText = country;
                countryDropdown.appendChild(option);
            });
        }


        function populateStates(country) {
            let c = address.innerText.split(",")
            address.innerText = country + "," + c[1] + "," + c[2];
            const stateDropdown = document.getElementById('state-dropdown');
            stateDropdown.innerHTML = '<option value="">Select State</option>'; // Reset dropdown
            const states = Object.keys(locationData[country] || {});
            states.forEach(state => {
                const option = document.createElement('option');
                option.value = state;
                option.innerText = state;
                stateDropdown.appendChild(option);
            });
        }

        function populateCities(country, state) {
            let c = address.innerText.split(",")
            address.innerText = c[0] + "," + state + "," + c[2];
            const cityDropdown = document.getElementById('city-dropdown');
            cityDropdown.innerHTML = '<option value="">Select City</option>';
            const cities = locationData[country][state] || [];
            cities.forEach(city => {
                const option = document.createElement('option');
                option.value = city;
                option.innerText = city;
                cityDropdown.appendChild(option);
            });
        }

        document.getElementById('country-dropdown').addEventListener('change', function () {

            populateStates(this.value);
            document.getElementById('city-dropdown').innerHTML = '<option value="">Select City</option>';
        });

        document.getElementById('state-dropdown').addEventListener('change', function () {
            const country = document.getElementById('country-dropdown').value;
            populateCities(country, this.value);
        });
        document.getElementById('city-dropdown').addEventListener('change', function () {
            let c = address.innerText.split(",")
            address.innerText = c[0] + "," + c[1] + "," + this.value;
        });

        populateCountries();


    </script>
</body>

</html>