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

                <title>Employee Dashbord</title>
            </head>

            <body>

                <div class="container mt-2">
                    <h1 class="text-center">Add Employee</h1>
                    <form action="/updateEmployee/${employee.id}" method="post" enctype="multipart/form-data">
                        <div class="form-group mb-3">
                            <label for="username">UserName</label>
                            <input type="text" class="form-control" name="userName" id="username"
                                placeholder="User Name" value="${employee.userName}">
                        </div>
                        <div class="form-group mb-3">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" name="name" id="name" value="${employee.name}"
                                placeholder="User Name">
                        </div>

                        <div class="form-group mb-3">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" name="email" id="email"
                                aria-describedby="emailHelp" placeholder="Enter email" value="${employee.email}">
                        </div>
                        <div class="form-group mb-3">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phoneNumber"
                                value="${employee.phoneNumber}" placeholder="User Name" />
                        </div>
                        <div class="form-group mb-3">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" name="password" id="exampleInputPassword1"
                                placeholder="Password" value="${employee.password}">
                        </div>

                        <div class="form-group mb-3">
                            <label for="education">Education</label>
                            <input type="text" class="form-control" name="education" id="education"
                                value="${employee.education}" placeholder="Education">
                        </div>
                        <div class="form-group mb-3">
                            <label for="company">Company Name</label>
                            <input type="text" class="form-control" name="company" id="company"
                                placeholder="Company Name" value="${employee.company}">
                        </div>
                        <div class="mb-3">
                            <label for="formFile" class="form-label">User Image</label>
                            <input class="form-control" type="file" name="image" accept="image/*" id="formFile"
                                value="${employee.photo}">
                        </div>
                        <div class="form-group mb-3">
                            <label for="address">Address</label>
                            <textarea class="form-control" id="address" name="Address"
                                rows="3">${employee.address}</textarea>
                        </div>
                        <div class="form-group mb-3">
                            <label for="selfBio">Self Bio</label>
                            <textarea class="form-control" id="selfBio" name="selfBio"
                                rows="3"> ${employee.selfBio}</textarea>
                        </div>

                        <div class="form-check mb-3 ">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Terms & Conditions</label>
                        </div>
                        <button type="submit" class="btn btn-primary mb-3">Update</button>
                    </form>

                    <a type="button" href="/logout" class="btn btn-danger mb-5">Logout</a>
                </div>


                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                    crossorigin="anonymous"></script>

            </body>

            </html>