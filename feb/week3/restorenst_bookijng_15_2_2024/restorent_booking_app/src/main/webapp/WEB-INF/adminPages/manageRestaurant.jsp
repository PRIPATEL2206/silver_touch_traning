<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous">
            <title>Manage Restaurant</title>
        </head>

        <body>
            <div class="page">

                <%@ include file="adminSideBar.jsp" %>
                    <div class="container card mt-5  px-3 pb-5">
                        <div class="page-wrapper ">
                            <div class="page-header d-print-none">
                                <h2 class="page-title">
                                    Restaurant Details
                                </h2>
                            </div>

                            <div class="d-flex justify-content-between">

                                <div class="d-flax mb-5">
                                    <button type="button" class="btn me-1 btn-secondary">copy</button>
                                    <button type="button" class="btn me-1 btn-info">csv</button>
                                    <button type="button" class="btn me-1 btn-success">Excel</button>
                                    <button type="button" class="btn me-1 btn-danger">PDF</button>
                                    <button type="button" class="btn me-1 btn-primary">Print</button>
                                </div>

                            </div>

                            <div class="border rounded">

                                <table class="table  table-borderless" style="width:100%">
                                    <thead class="p-1">
                                        <tr>
                                            <th scope="col">no</th>
                                            <th scope="col">City Name</th>
                                            <th scope="col">Area Name</th>
                                            <th scope="col">Restaurant Name</th>
                                            <th scope="col" style="width:45%">Restaurant Address</th>
                                            <th scope="col">Phone</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${restaurants}" var="restaurant">
                                            <tr>
                                                <th scope="row">${restaurant.id}</th>
                                                <td>${cities.get(restaurant.city)}</td>
                                                <td>${areas.get(restaurant.area)}</td>
                                                <td> ${restaurant.name}</td>
                                                <td> ${restaurant.address}</td>
                                                <td> ${restaurant.contectNumber}</td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>

                                </table>
                            </div>

                        </div>
                    </div>
            </div>
        </body>

        </html>