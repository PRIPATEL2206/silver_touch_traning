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

                <title>DashBord</title>
            </head>

            <body>
                <%@ include file="navbar.jsp" %>

                    <div class="container mt-5">

                        <h2>Consoltents</h2>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">id</th>
                                    <th scope="col">username</th>
                                    <th scope="col">email</th>
                                    <th scope="col">is Verified</th>
                                    <th scope="col">specification</th>
                                    <th scope="col">action</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${consoltents}" var="consoltent">
                                    <tr>
                                        <th scope="row">${consoltent.id}</th>
                                        <td>${consoltent.username}</td>
                                        <td>${consoltent.email}</td>
                                        <td>${consoltent.isVerified()}</td>
                                        <td>${consoltent.specification}</td>
                                        <td><a href="bookApointment/${consoltent.id}" class="btn btn-primary">Book
                                                Now</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                        <h2>Apoitments</h2>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">id</th>
                                    <th scope="col">consultant Id</th>
                                    <th scope="col">Start Time</th>
                                    <th scope="col">End Time</th>
                                    <th scope="col">status</th>
                                    <th scope="col">description</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${appointments}" var="appointment">
                                    <tr>
                                        <th scope="row">${appointment.id}</th>
                                        <td>${appointment.consultant_Id}</td>
                                        <td>${appointment.startTime}</td>
                                        <td>${appointment.endTime}</td>
                                        <td>${appointment.status}</td>
                                        <td>${appointment.description}</td>
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