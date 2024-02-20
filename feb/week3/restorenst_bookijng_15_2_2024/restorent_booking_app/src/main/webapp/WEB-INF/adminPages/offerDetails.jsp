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
            <title>Offers Deteil</title>
        </head>

        <body>
            <div class="page">

                <%@ include file="adminSideBar.jsp" %>
                    <div class="container card mt-5  px-3 pb-5">
                        <div class="page-wrapper ">
                            <div class="page-header d-print-none">
                                <h2 class="page-title">
                                    Offers Detail
                                </h2>
                            </div>

                            <div class="d-flex justify-content-between">

                                <%@ include file="../componets/toolbar.jsp" %>

                            </div>

                            <div class="border rounded">

                                <table class="table  table-borderless" style="width:100%" id="table">
                                    <thead class="p-1">
                                        <tr>
                                            <th scope="col">no</th>
                                            <th scope="col">Restorent</th>
                                            <th scope="col">Offer Name</th>
                                            <th scope="col">Offer Discount</th>
                                            <th scope="col">Product</th>
                                            <th scope="col">Start From</th>
                                            <th scope="col">End</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${offers}" var="offer">
                                            <tr>
                                                <th scope="row">${offer.id}</th>
                                                <td>${restaurants.get(offer.doneByRestorent)}</td>
                                                <td> ${offer.name}</td>
                                                <td> ${offer.discount} %</td>
                                                <td>${categories.get(offer.categoryId)} -
                                                    ${subCategories.get(offer.subCategoryId)}</td>
                                                <td> ${offer.startDate}</td>
                                                <td> ${offer.endDate}</td>

                                            </tr>
                                        </c:forEach>

                                    </tbody>

                                </table>
                            </div>
                            <%@ include file="../componets/pagination.jsp" %>
                        </div>
                    </div>
            </div>
        </body>

        </html>