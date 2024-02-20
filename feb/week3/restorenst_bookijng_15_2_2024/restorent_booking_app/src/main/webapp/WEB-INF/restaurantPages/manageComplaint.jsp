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
            <title>Manage Complaint</title>
        </head>

        <body>
            <div class="page">

                <%@ include file="restaurantSideBar.jsp" %>
                    <div class="container card mt-5  px-3 pb-5">
                        <div class="page-wrapper ">
                            <div class="page-header d-print-none">
                                <h2 class="page-title">
                                    Complaint Details
                                </h2>
                            </div>

                            <div class="d-flex justify-content-between">

                                <%@ include file="../componets/toolbar.jsp" %>
                                    <div class="d-flex mb-5">

                                        <a type="button" href="addComplaint" class="btn me-1 btn-success">Add +</a>
                                    </div>
                            </div>

                            <div class="border rounded">

                                <table class="table  table-borderless" style="width:100%" id="table">
                                    <thead class="p-1">
                                        <tr>
                                            <th scope="col">no</th>
                                            <th scope="col">Subject</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Complaint Date</th>
                                            <th scope="col">Reply</th>
                                            <th scope="col">Reply Date</th>
                                            <th scope="col">Attechment</th>
                                            <th scope="col">Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${complaints}" var="complaint">
                                            <tr>
                                                <th scope="row">${complaint.id}</th>
                                                <td>${complaint.subject}</td>
                                                <td>${complaint.description}</td>
                                                <td> ${complaint.complaintDate}</td>
                                                <td> ${complaint.reply}</td>
                                                <td> ${complaint.replyDate}</td>
                                                <td>
                                                    <a href="/complaints/${complaint.attachment}">
                                                        <svg xmlns="http://www.w3.org/2000/svg"
                                                            class="icon icon-tabler icon-tabler-file" width="24"
                                                            height="24" viewBox="0 0 24 24" stroke-width="1.5"
                                                            stroke="#7280F6" fill="none" stroke-linecap="round"
                                                            stroke-linejoin="round">
                                                            <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                                            <path d="M14 3v4a1 1 0 0 0 1 1h4" />
                                                            <path
                                                                d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2z" />
                                                        </svg>
                                                    </a>
                                                </td>
                                                <td>
                                                    <span
                                                        class="badge rounded-pill text-bg-success">${complaint.status}</span>
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