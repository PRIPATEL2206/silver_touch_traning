<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add Area</title>
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
                                <c:if test="${ area != null }">
                                    Update Area
                                </c:if>
                                <c:if test="${ area == null }">
                                    Add Area
                                </c:if>

                            </h2>
                        </div>
                        <c:if test="${ area != null }">
                            <form action="${area.id}" method="post">
                        </c:if>
                        <c:if test="${ area == null }">
                            <form action="addArea" method="post">
                        </c:if>
                        <div class="mb-3">
                            <label for="city" class="form-label">Select City</label>
                            <select class="form-select" aria-label="Default select example" name="cityId" required>
                                <c:forEach items="${cities}" var="city">
                                    <c:if test="${ city.id == area.cityId }">
                                        <option selected value="${city.id}">${city.cityName}</option>
                                    </c:if>
                                    <c:if test="${ city.id != area.cityId }">
                                        <option value="${city.id}">${city.cityName}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="areaName" class="form-label">Area Name</label>
                            <input type="text" class="form-control" id="areaName" name="areaName"
                                value="${area.areaName}" required>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">City Discription</label>
                            <textarea name="description" class="form-control" id="description" cols="30" rows="3"
                                required>${area.description}</textarea>
                        </div>
                        <c:if test="${ area != null }">
                            <button type="submit" class="btn btn-primary float-end">update</button>

                        </c:if>
                        <c:if test="${ area == null }">
                            <button type="submit" class="btn btn-primary float-end">Add</button>

                        </c:if>

                        </form>



                    </div>
                </div>
        </div>
    </body>

    </html>