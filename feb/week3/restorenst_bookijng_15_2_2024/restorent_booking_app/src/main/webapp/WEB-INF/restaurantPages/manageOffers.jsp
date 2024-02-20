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
            <title>Manage Offers</title>
        </head>

        <body>
            <div class="page">

                <%@ include file="restaurantSideBar.jsp" %>
                    <div class="container card mt-5  px-3 pb-5">
                        <div class="page-wrapper ">
                            <div class="page-header d-print-none">
                                <h2 class="page-title">
                                    Offers Details
                                </h2>
                            </div>

                            <div class="d-flex justify-content-between">

                                <%@ include file="../componets/toolbar.jsp" %>
                                    <div class="d-flex mb-5">

                                        <a type="button" href="addOffer" class="btn me-1 btn-success">Add +</a>
                                    </div>
                            </div>

                            <div class="border rounded">

                                <table class="table  table-borderless" style="width:100%" id="table">
                                    <thead class="p-1">
                                        <tr>
                                            <th scope="col">no</th>
                                            <th scope="col">Category Name</th>
                                            <th scope="col">SubCategory Name</th>
                                            <th scope="col">Offer Name</th>
                                            <th scope="col">Offer Discription</th>
                                            <th scope="col">Start Date</th>
                                            <th scope="col">End Date</th>
                                            <th scope="col">Discount(%)</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${offers}" var="offer">
                                            <tr>
                                                <th scope="row">${offer.id}</th>
                                                <td>${categories.get(offer.categoryId)}</td>
                                                <td>${subCategories.get(offer.subCategoryId)}</td>
                                                <td> ${offer.name}</td>
                                                <td> ${offer.description}</td>
                                                <td> ${offer.startDate}</td>
                                                <td> ${offer.endDate}</td>
                                                <td> ${offer.discount}</td>
                                                <td>
                                                    <a href="editOffer/${offer.id}" class="btn btn-primary ">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                            class="icon icon-tabler icon-tabler-edit" width="24"
                                                            height="24" viewBox="0 0 24 24" stroke-width="1"
                                                            stroke="white" fill="none" stroke-linecap="round"
                                                            stroke-linejoin="round">
                                                            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                                            <path
                                                                d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1" />
                                                            <path
                                                                d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z" />
                                                            <path d="M16 5l3 3" />
                                                        </svg>
                                                    </a>
                                                    <a href="deleteOffer/${offer.id}" class="btn btn-danger">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                            class="icon icon-tabler icon-tabler-trash" width="24"
                                                            height="24" viewBox="0 0 24 24" stroke-width="1.5"
                                                            stroke="currentColor" fill="none" stroke-linecap="round"
                                                            stroke-linejoin="round">
                                                            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                                            <path d="M4 7l16 0" />
                                                            <path d="M10 11l0 6" />
                                                            <path d="M14 11l0 6" />
                                                            <path d="M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12" />
                                                            <path d="M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3" />
                                                        </svg>
                                                    </a>
                                                </td>
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