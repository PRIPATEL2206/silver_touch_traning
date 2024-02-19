<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page session="false" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                    crossorigin="anonymous">

                <title>All User</title>
            </head>

            <body>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="/adminDashbord">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
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

                <div class="container mt-5">
                    <h1 class="mb-3">Users</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">User Name</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone Number</th>
                                <th scope="col">Address</th>
                                <th scope="col">Education</th>
                                <th scope="col">Company</th>
                                <th scope="col">Bio</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${employees}" var="employee">
                                <tr>
                                    <th scope="row">${employee.id}</th>
                                    <td>${employee.userName}</td>
                                    <td>${employee.name}</td>
                                    <td>${employee.email}</td>
                                    <td>${employee.phoneNumber}</td>
                                    <td>${employee.address}</td>
                                    <td>${employee.education}</td>
                                    <td>${employee.company}</td>
                                    <td>${employee.selfBio}</td>
                                    <td><a type="button" href="/updateEmployee/${employee.id}"
                                            class="btn btn-primary">edit</a>
                                    </td>
                                    <td><a type="button" href="/delete/${employee.id}" class="btn btn-danger">delete</a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="container mt-5">
                    <h1 class="mb-3">Admins</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">id</th>
                                <th scope="col">User Name</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone Number</th>
                                <th scope="col">Address</th>
                                <th scope="col">Edit</th>
                                <th scope="col">Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${admins}" var="admin">
                                <tr>
                                    <th scope="row">${admin.id}</th>
                                    <td>${admin.username}</td>
                                    <td>${admin.name}</td>
                                    <td>${admin.email}</td>
                                    <td>${admin.phoneNumber}</td>
                                    <td>${admin.address}</td>
                                    <td><a type="button" href="/updateAdmin/${admin.id}"
                                            class="btn btn-primary">edit</a>
                                    </td>
                                    <td><a type="button" href="/deleteAdmin/${admin.id}"
                                            class="btn btn-danger">delete</a>
                                    </td>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                    crossorigin="anonymous"></script>

            </body>

            </html>