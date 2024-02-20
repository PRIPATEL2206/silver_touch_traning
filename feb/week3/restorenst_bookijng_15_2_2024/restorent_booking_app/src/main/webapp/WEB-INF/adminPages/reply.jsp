<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Replay</title>
        <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>

    <body>
        <div class="page">

            <%@ include file="adminSideBar.jsp" %>
                <div class="container card mt-5  px-3 pb-5">
                    <div class="page-wrapper ">
                        <div class="page-header d-print-none">
                            <h2 class="page-title fw-bold">
                                Replay
                            </h2>
                        </div>

                        <form action="${complain.id}" method="post">

                            <table class="table border">

                                <tbody>

                                    <tr>
                                        <td>SUBJECT</td>
                                        <td>${complain.subject}</td>
                                    </tr>
                                    <tr>
                                        <td>@DESCRIPTION</td>
                                        <td>${complain.description}</td>
                                    </tr>
                                    <tr>
                                        <td>ATTECHMENT</td>
                                        <td>
                                            <a href="/complaints/${complain.attachment}">
                                                <svg xmlns="http://www.w3.org/2000/svg"
                                                    class="icon icon-tabler icon-tabler-file" width="24" height="24"
                                                    viewBox="0 0 24 24" stroke-width="1.5" stroke="#7280F6" fill="none"
                                                    stroke-linecap="round" stroke-linejoin="round">
                                                    <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                                    <path d="M14 3v4a1 1 0 0 0 1 1h4" />
                                                    <path
                                                        d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2z" />
                                                </svg>
                                            </a>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>

                            <div class="mb-3">
                                <label for="reply" class="form-label">Reply</label>
                                <input type="text" class="form-control" id="reply" name="reply" required>
                            </div>


                            <button type="submit" class="btn btn-primary float-end">Add</button>

                        </form>



                    </div>
                </div>
        </div>

    </body>

    </html>