<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add Complaint</title>
        <link href="https://cdn.jsdelivr.net/npm/tabler@latest/dist/css/tabler.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>

    <body>
        <div class="page">

            <%@ include file="restaurantSideBar.jsp" %>
                <div class="container card mt-5  px-3 pb-5">
                    <div class="page-wrapper ">
                        <div class="page-header d-print-none">
                            <h2 class="page-title fw-bold">
                                Add Complaint
                            </h2>
                        </div>

                        <form action="addComplaint" method="post" enctype="multipart/form-data">

                            <div class="mb-3">
                                <label for="subject" class="form-label">Complaint Subject</label>
                                <input type="text" class="form-control" id="subject" name="subject" required>
                            </div>
                            <div class="mb-3">
                                <label for="description" class="form-label">Product Price</label>
                                <input type="text" class="form-control" id="description" name="description" required>
                            </div>

                            <div class="mb-3">
                                <label for="attechment" class="form-label">Attechment</label>
                                <input type="file" class="form-control" id="attechment" name="image" required>
                            </div>
                            <button type="submit" class="btn btn-primary float-end">Add</button>
                        </form>



                    </div>
                </div>
        </div>
    </body>

    </html>